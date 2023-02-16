package com.techeer.cokkiri.domain.comment.controller;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.service.CommentService;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.study.service.StudyService;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import com.techeer.cokkiri.global.annotation.LoginUser;
import com.techeer.cokkiri.global.result.ResultCode;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "댓글 API")
@RequestMapping("/api/v1/comments")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
// @CrossOrigin(origins = "*")
public class CommentController {

  private final CommentService commentService;
  private final StudyService studyService;

  @ApiOperation(value = "댓글 등록")
  @LoginRequired
  @PostMapping
  public ResponseEntity<ResultResponse> createComment(
      @Valid @RequestBody CommentDto.CreateRequest createRequest, @ApiIgnore @LoginUser User user) {

    Study study = studyService.findByStudyId(createRequest.getStudyId());

    commentService.registerComment(createRequest, user, study);

    return ResponseEntity.ok(ResultResponse.of(ResultCode.REGISTER_COMMENT_SUCCESS));
  }

  @ApiOperation(value = "스터디 id와 스터디 주차로 댓글 목록 조회")
  @GetMapping("/{studyId}")
  public ResponseEntity<ResultResponse> findCommentByStudyIdAndStudyWeek(
      @PathVariable Long studyId, @RequestParam Integer studyWeek) {

    List<CommentDto.InfoResponse> infoResponseList =
        commentService.findCommentByStudyIdAndStudyWeek(studyId, studyWeek);

    return ResponseEntity.ok(ResultResponse.of(ResultCode.COMMENT_FIND_SUCCESS, infoResponseList));
  }
}
