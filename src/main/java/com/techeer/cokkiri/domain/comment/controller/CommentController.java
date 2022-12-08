package com.techeer.cokkiri.domain.comment.controller;


import com.techeer.cokkiri.domain.comment.dto.CommentCreateRequest;
import com.techeer.cokkiri.domain.comment.service.CommentService;
import com.techeer.cokkiri.global.result.ResultCode;
import com.techeer.cokkiri.global.result.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/comments")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ResultResponse> createComment(@Valid @RequestBody CommentCreateRequest request) {

        commentService.registerComment(request);

        return ResponseEntity.ok(ResultResponse.of(ResultCode.REGISTER_COMMENT_SUCCESS));
    }
}
