package com.techeer.cokkiri.domain.comment.mapper;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

  public Comment toEntity(CommentDto.CreateRequest dto, User user, Study study) {

    Comment comment =
        Comment.builder()
            .content(dto.getContent())
            .studyWeek(dto.getStudyWeek())
            .user(user)
            .study(study)
            .build();

    return comment;
  }

  public CommentDto.ResponseInfo toDto(Comment comment) {
    CommentDto.ResponseInfo info =
        CommentDto.ResponseInfo.builder()
            .content(comment.getContent())
            .likeCount(comment.getLikeCount())
            .dislikeCount(comment.getDislikeCount())
            .userCommentInfo(toDto(comment.getUser()))
            .build();
    return info;
  }

  public UserDto.ResponseCommentInfo toDto(User user) {
    return UserDto.ResponseCommentInfo.builder()
        .userId(user.getId())
        .userName(user.getNickname())
        .build();
  }

  public List<CommentDto.ResponseInfo> toDtoList(List<Comment> comments) {
    return comments.stream().map(this::toDto).collect(Collectors.toList());
  }
}
