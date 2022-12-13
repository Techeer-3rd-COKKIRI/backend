package com.techeer.cokkiri.domain.comment.dto;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CommentDto {

  private Integer studyWeek;
  private String content;
}
