package com.techeer.cokkiri.domain.study.controller;

import static com.techeer.cokkiri.global.result.ResultCode.STUDY_CREATE_SUCCESS;
import static com.techeer.cokkiri.global.result.ResultCode.STUDY_GET_SUCCESS;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.study.exception.StudyDuplicationException;
import com.techeer.cokkiri.domain.study.service.StudyService;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import com.techeer.cokkiri.global.annotation.LoginUser;
import com.techeer.cokkiri.global.result.ResultResponse;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

  @GetMapping("{studyId}")
  public ResponseEntity<ResultResponse> findStudyByStudyId(@PathVariable Long studyId) {
    Study study = studyService.findByStudyId(studyId);
    return ResponseEntity.ok(ResultResponse.of(STUDY_GET_SUCCESS, study));
  }
}
