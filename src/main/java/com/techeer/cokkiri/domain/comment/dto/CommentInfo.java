package com.techeer.cokkiri.domain.comment.dto;

import com.techeer.cokkiri.domain.user.dto.UserCommentInfo;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfo {

  @NotNull private String content;
  private Integer likeCount;
  private Integer dislikeCount;
  @NotNull private UserCommentInfo userCommentInfo;
}
