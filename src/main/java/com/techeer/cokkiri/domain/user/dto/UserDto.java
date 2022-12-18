package com.techeer.cokkiri.domain.user.dto;

import static com.techeer.cokkiri.domain.user.constant.UserConstants.*;

import javax.validation.constraints.NotBlank;
import lombok.*;

public class UserDto {

  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Response {
    private Long id;
    private String username;
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Request {
    @NotBlank(message = "username을 입력해주세요")
    private String username;
    //  @Pattern(
    //  message = "대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.",
    //  regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
    @Builder.Default private String password = DEFAULT_PASSWORD;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickname;

    @Builder.Default private String imageUrl = DEFAULT_IMAGE_URL;
    @Builder.Default private String bio = DEFAULT_BIO;
  }
}
