package com.techeer.cokkiri.domain.study.dto.request;

import com.techeer.cokkiri.domain.user.entity.User;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateStudyRequest {

  private User manager;

  private String studyName;

  private String studyPassword; // 추후 인코딩 추가

  private Integer userLimit;

  private String introduction;

  private Integer studyCycle;

  private LocalDate startDate;

  private LocalDate finishDate;
}
