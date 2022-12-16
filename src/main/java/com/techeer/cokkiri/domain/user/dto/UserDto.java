package com.techeer.cokkiri.domain.user.dto;

import javax.validation.constraints.NotBlank;
import lombok.*;

public class UserDto {

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Request {
    @NotBlank private String username;
    @NotBlank private String password;
  }
}
