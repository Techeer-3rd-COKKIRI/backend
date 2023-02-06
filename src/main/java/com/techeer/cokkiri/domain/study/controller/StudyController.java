package com.techeer.cokkiri.domain.study.controller;

import static com.techeer.cokkiri.global.result.ResultCode.*;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.study.exception.StudyDuplicationException;
import com.techeer.cokkiri.domain.study.service.StudyService;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import com.techeer.cokkiri.global.annotation.LoginUser;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "스터디 API")
@RestController
@RequestMapping("api/v1/studies")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*")
public class StudyController {
  private final StudyService studyService;

  @ApiOperation(value = "스터디 개설")
  @PostMapping
  @LoginRequired
  public ResponseEntity<ResultResponse> createStudy(
      @Valid @RequestBody StudyDto.CreateRequest createRequest,
      @ApiIgnore @LoginUser User loginUser) {
    if (studyService.isDuplicatedStudy(createRequest.getStudyName())) {
      throw new StudyDuplicationException();
    }
    studyService.createStudy(createRequest, loginUser);
    return ResponseEntity.ok(ResultResponse.of(STUDY_CREATE_SUCCESS));
  }

  @ApiOperation(value = "스터디 조회")
  @GetMapping("{studyId}")
  public ResponseEntity<ResultResponse> findStudyByStudyId(@PathVariable Long studyId) {
    StudyDto.FindResponse findResponse = studyService.findStudyDtoById(studyId);
    return ResponseEntity.ok(ResultResponse.of(STUDY_GET_SUCCESS, findResponse));
  }

  @ApiOperation(value = "스터디 최신순 페이징 조회")
  @GetMapping("/page/{page}")
  public ResponseEntity<ResultResponse> getStudyListWithPagingNewest(
      @PathVariable Integer page, @RequestParam(defaultValue = "20") Integer size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
    List<StudyDto.InfoResponse> infoResponseList = studyService.getStudyListWithPaging(pageRequest);
    return ResponseEntity.ok(ResultResponse.of(STUDY_PAGING_GET_SUCCESS, infoResponseList));
  }

  @ApiOperation(value = "유저별 스터디 조회")
  @GetMapping("/user/{page}")
  @LoginRequired
  public ResponseEntity<ResultResponse> getUserStudies(
      @ApiIgnore @LoginUser User loginUser,
      @PathVariable Integer page,
      @RequestParam(defaultValue = "8") Integer size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
    List<StudyDto.InfoResponse> infoResponseList =
        studyService.getStudyListByUserIdWithPaging(loginUser.getId(), pageRequest);
    return ResponseEntity.ok(ResultResponse.of(USER_STUDY_PAGING_GET_SUCCESS, infoResponseList));
  }
}
