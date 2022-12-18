package com.techeer.cokkiri.domain.study.dto;

import static com.techeer.cokkiri.domain.study.constant.StudyConstants.*;

import java.time.LocalDate;
import javax.validation.constraints.Pattern;
import lombok.*;

public class StudyDto {
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Response {
    private Long id;
    private String studyName;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Request {
    @Pattern(message = "스터디의 이름은 3자 이상 20자 이하여야 합니다.", regexp = "^.{3,20}$")
    private String studyName;

    @Builder.Default private String studyPassword = DEFAULT_PASSWORD; // 추후 인코딩 추가
    @Builder.Default private Integer userLimit = DEFAULT_USER_LIMIT;
    @Builder.Default private String introduction = DEFAULT_INTRODUCTION;
    @Builder.Default private Integer studyCycle = DEFAULT_STUDY_CYCLE;
    @Builder.Default private LocalDate startDate = DEFAULT_START_DATE;
    @Builder.Default private LocalDate finishDate = DEFAULT_FINISH_DATE;
  }
}
