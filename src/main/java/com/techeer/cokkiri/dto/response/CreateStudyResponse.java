package com.techeer.cokkiri.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateStudyResponse {
  private Long id;
  private String studyName;
}
