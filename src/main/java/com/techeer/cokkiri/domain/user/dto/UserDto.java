package com.techeer.cokkiri.domain.user.dto;

import static com.techeer.cokkiri.domain.user.constant.UserConstants.*;
import static com.techeer.cokkiri.global.constant.RegExp.PASSWORD_REGEXP;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

public class UserDto {

  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  public static class RegisterResponse {
    private Long id;
    private String username;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class RegisterRequest {
    @NotBlank(message = "username을 입력해주세요")
    private String username;
    //  @Pattern(
    //  message = "대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.",
    //  regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
    @Builder.Default private String password = DEFAULT_PASSWORD;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickname;

    @Builder.Default private String bio = DEFAULT_BIO;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class LoginRequest {

    @Size(min = 5, max = 20)
    private String username;

    @Pattern(
            message = "비밀번호 형식이 맞지 않습니다.",
            regexp = PASSWORD_REGEXP
    )
    private String password;
  }

}
