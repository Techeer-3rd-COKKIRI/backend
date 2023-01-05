package com.techeer.cokkiri.domain.comment.dto;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import javax.validation.constraints.*;
import lombok.*;

public class CommentDto {

  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @Getter
  public static class CreateRequest {
    @Min(1)
    private Integer studyWeek;

    @NotBlank private String content;
    @NotNull private Long studyId;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class InfoResponse {
    private String content;
    private Integer likeCount;
    private Integer dislikeCount;
    private UserDto.CommentInfoResponse userCommentInfo;
  }
}
