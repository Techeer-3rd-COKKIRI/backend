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
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

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
}
