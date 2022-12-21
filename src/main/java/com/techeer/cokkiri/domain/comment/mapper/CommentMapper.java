package com.techeer.cokkiri.domain.comment.mapper;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.dto.CommentInfo;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.dto.UserCommentInfo;
import com.techeer.cokkiri.domain.user.entity.User;
import java.util.List;
import java.util.stream.Collectors;
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

  public CommentInfo toDto(Comment comment) {
    CommentInfo info =
        CommentInfo.builder()
            .content(comment.getContent())
            .likeCount(comment.getLikeCount())
            .dislikeCount(comment.getDislikeCount())
            .userCommentInfo(CommentMapper.toDto(comment.getUser()))
            .build();
    return info;
  }

  public static UserCommentInfo toDto(User user) {
    return UserCommentInfo.builder()
        .userId(user.getId())
        .userName(user.getNickname())
        .imageUrl(user.getImageUrl())
        .build();
  }

  public List<CommentInfo> toDtoList(List<Comment> comments) {
    return comments.stream().map(this::toDto).collect(Collectors.toList());
  }
}
