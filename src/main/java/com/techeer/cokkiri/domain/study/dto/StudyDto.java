package com.techeer.cokkiri.domain.study.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

import static com.techeer.cokkiri.domain.study.constant.StudyConstants.*;

public class StudyDto {
  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Response {
    private Long id;
    private String studyName;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Request {
    @NotEmpty
    private String studyName;
    @Builder.Default private String studyPassword = DEFAULT_PASSWORD; // 추후 인코딩 추가
    @Builder.Default private Integer userLimit = DEFAULT_USER_LIMIT;
    @Builder.Default private String introduction = DEFAULT_INTRODUCTION;
    @Builder.Default private Integer studyCycle = DEFAULT_STUDY_CYCLE;
    @Builder.Default private LocalDate startDate = DEFAULT_START_DATE;
    @Builder.Default private LocalDate finishDate = DEFAULT_FINISH_DATE;
  }
}
