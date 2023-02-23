package com.techeer.cokkiri.domain.amazons3;

import com.techeer.cokkiri.global.result.ResultCode;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/s3")
public class AmazonS3Controller {

    private final AmazonS3Service amazonS3Service;

    /**
     * Amazon S3에 파일 업로드
     * @return 성공 시 200 Success와 함께 업로드 된 파일의 파일명 리스트 반환
     */
    @ApiOperation(value = "Amazon S3에 파일 업로드", notes = "Amazon S3에 파일 업로드 ")
    @PostMapping("/file")
    public ResponseEntity<ResultResponse> uploadFile(@ApiParam(value="파일들(여러 파일 업로드 가능)", required = true) @RequestPart List<MultipartFile> multipartFile) {
//        return ApiResponse.success(amazonS3Service.uploadFile(multipartFile));
        List<String> fileLists = amazonS3Service.uploadFile(multipartFile);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.IMAGE_UPLOAD_SUCCESS, fileLists));
    }

    /**
     * Amazon S3에 업로드 된 파일을 삭제
     * @return 성공 시 200 Success
     */
    @ApiOperation(value = "Amazon S3에 업로드 된 파일을 삭제", notes = "Amazon S3에 업로드된 파일 삭제")
    @DeleteMapping("/file")
    public ResponseEntity<ResultResponse> deleteFile(@ApiParam(value="파일 하나 삭제", required = true) @RequestParam String fileName) {
        amazonS3Service.deleteFile(fileName);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.IMAGE_UPLOAD_FAILED));
    }
}