package com.techeer.cokkiri.domain.study.controller;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.study.exception.StudyDuplicationException;
import com.techeer.cokkiri.domain.study.service.StudyService;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import com.techeer.cokkiri.global.annotation.LoginUser;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

import static com.techeer.cokkiri.global.result.ResultCode.*;

@RestController
@RequestMapping("api/v1/studies")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class StudyController {
  private final StudyService studyService;

  @PostMapping
  @LoginRequired
  public ResponseEntity<ResultResponse> createStudy(
      @Valid @RequestBody StudyDto.Request studyRequest, @ApiIgnore @LoginUser User loginUser) {
    if (studyService.isDuplicatedStudy(studyRequest.getStudyName())) {
      throw new StudyDuplicationException();
    }
    studyService.createStudy(studyRequest, loginUser);
    return ResponseEntity.ok(ResultResponse.of(STUDY_CREATE_SUCCESS));
  }

  @ApiOperation(value = "스터디 조회")
  @GetMapping("{studyId}")
  public ResponseEntity<ResultResponse> findStudyByStudyId(@PathVariable Long studyId) {
    StudyDto.FindResponse studyResponse = studyService.findStudyDtoById(studyId);
    return ResponseEntity.ok(ResultResponse.of(STUDY_GET_SUCCESS, studyResponse));
  }

  @ApiOperation(value = "스터디 최신순 페이징 조회")
  @GetMapping("/page/{page}")
  public ResponseEntity<ResultResponse> getStudyListWithPagingNewest(
      @PathVariable Integer page, @RequestParam(defaultValue = "20") Integer size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
    List<StudyDto.InfoResponse> studyInfoResponseList =
        studyService.getStudyListWithPaging(pageRequest);
    return ResponseEntity.ok(ResultResponse.of(STUDY_PAGING_GET_SUCCESS, studyInfoResponseList));
  }
}
