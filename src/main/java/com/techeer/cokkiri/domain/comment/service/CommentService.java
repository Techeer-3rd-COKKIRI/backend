package com.techeer.cokkiri.domain.comment.service;

import com.techeer.cokkiri.domain.comment.dto.CommentCreateRequest;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.comment.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;

  public Comment registerComment(CommentCreateRequest request) {

    Comment registerContent = registerCommentRequestToEntity(request);
    return commentRepository.save(registerContent);
  }

  public Comment registerCommentRequestToEntity(CommentCreateRequest request) {

    return Comment.builder().content(request.getContent()).build();
  }
}
