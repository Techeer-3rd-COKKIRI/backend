package com.techeer.cokkiri.domain.user.dto;

import static com.techeer.cokkiri.global.constant.RegExp.PASSWORD_REGEXP;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.*;

public class UserDto {

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Request {

    @Size(min = 5, max = 20)
    private String username;

    @Pattern(message = "비밀번호 형식이 맞지 않습니다.", regexp = PASSWORD_REGEXP)
    private String password;
  }
}
