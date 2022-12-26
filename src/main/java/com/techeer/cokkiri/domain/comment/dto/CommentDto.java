package com.techeer.cokkiri.domain.comment.dto;

import javax.validation.constraints.NotNull;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.user.dto.UserDto;
import lombok.*;

public class CommentDto {

  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @Getter
  public static class Request {

    @NotNull private Integer studyWeek;
    @NotNull private String content;
    @NotNull private Long studyId;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ResponseInfo {
    private String content;
    private Integer likeCount;
    private Integer dislikeCount;
    private UserDto.ResponseCommentInfo userCommentInfo;
    private StudyDto.ResponseCommentInfo studyCommentInfo;
  }

}
