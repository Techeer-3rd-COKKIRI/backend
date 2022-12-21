package com.techeer.cokkiri.domain.comment.controller;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.dto.CommentInfo;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.comment.mapper.CommentMapper;
import com.techeer.cokkiri.domain.comment.service.CommentService;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.study.service.StudyService;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import com.techeer.cokkiri.global.annotation.LoginUser;
import com.techeer.cokkiri.global.result.ResultCode;
import com.techeer.cokkiri.global.result.ResultResponse;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RequestMapping("/api/v1/comments")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentController {

  private final CommentService commentService;
  private final StudyService studyService;

  @LoginRequired
  @PostMapping
  public ResponseEntity<ResultResponse> createComment(
      @Valid @RequestBody CommentDto.Request request, @ApiIgnore @LoginUser User user) {

    Study study = studyService.findByStudyId(request.getStudyId());

    commentService.registerComment(request, user, study);

    return ResponseEntity.ok(ResultResponse.of(ResultCode.REGISTER_COMMENT_SUCCESS));
  }

  @LoginRequired
  @GetMapping("/{studyWeek}")
  public ResponseEntity<ResultResponse> findCommentByStudyWeek(@PathVariable Integer studyWeek) {

    List<CommentInfo> comments = commentService.findCommentByStudyWeek(studyWeek);

    return ResponseEntity.ok(ResultResponse.of(ResultCode.COMMENT_FIND_SUCCESS, comments));
  }
}
