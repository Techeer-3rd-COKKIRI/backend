package com.techeer.cokkiri.domain.user.dto;

import static com.techeer.cokkiri.domain.user.constant.UserConstants.*;
import static com.techeer.cokkiri.global.constant.RegExp.PASSWORD_REGEXP;
import static com.techeer.cokkiri.global.constant.RegExp.USERNAME_REGEXP;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.*;

public class UserDto {

  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class RegisterResponse {
    private Long id;
    private String username;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class RegisterRequest {

    @Pattern(message = "형식이 맞지 않습니다.", regexp = USERNAME_REGEXP)
    private String username;

    @Pattern(message = "대소문자와 숫자, 특수문자를 포함한 8-16자리의 비밀번호를 입력하세요.", regexp = PASSWORD_REGEXP)
    private String password;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickname;

    @Builder.Default private String bio = DEFAULT_BIO;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class LoginRequest {

    @Pattern(message = "형식이 맞지 않습니다.", regexp = USERNAME_REGEXP)
    private String username;

    @Pattern(message = "비밀번호 형식이 맞지 않습니다.", regexp = PASSWORD_REGEXP)
    private String password;
  }
}
