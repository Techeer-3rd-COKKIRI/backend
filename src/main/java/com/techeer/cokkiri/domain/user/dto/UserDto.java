package com.techeer.cokkiri.domain.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import static com.techeer.cokkiri.global.constant.RegExp.PASSWORD_REGEXP;

public class UserDto {

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Request {

    @Length(max = 20)
    private String username;

    @Pattern(
            message = "비밀번호 형식이 맞지 않습니다.",
            regexp = PASSWORD_REGEXP
    )
    private String password;
  }
}
