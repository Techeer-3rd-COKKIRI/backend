package com.techeer.cokkiri.domain.comment.mapper;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.entity.Comment;

public class CommentMapper {

  public static Comment toEntity(CommentDto request) {

    return Comment.builder()
        .content(request.getContent())
        .studyWeek(request.getStudyWeek())
        .build();
  }
}
