package com.techeer.cokkiri.domain.comment.service;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.comment.mapper.CommentMapper;
import com.techeer.cokkiri.domain.comment.repository.CommentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentService {

  private final CommentRepository commentRepository;

  public void registerComment(CommentDto commentDto) {

    Comment comment = CommentMapper.toEntity(commentDto);

    commentRepository.save(comment);
  }


}
