package com.techeer.cokkiri.domain.comment.mapper;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

  public Comment toEntity(CommentDto.Request dto, User user, Study study) {

    Comment comment =
        Comment.builder()
            .content(dto.getContent())
            .studyWeek(dto.getStudyWeek())
            .user(user)
            .study(study)
            .build();

    return comment;
  }
}
