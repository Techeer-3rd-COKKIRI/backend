package com.techeer.cokkiri.domain.user.dto;

import static com.techeer.cokkiri.global.constant.RegExp.PASSWORD_REGEXP;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ApiModel(value = "UserRegisterRequest")
public class UserRegisterRequest {

  @NotBlank(message = "username을 입력해주세요")
  private String username;

  @Pattern(message = "대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.", regexp = PASSWORD_REGEXP)
  private String password;

  @NotBlank(message = "닉네임을 입력해주세요")
  private String nickname;

  @URL private String imageUrl;

  private String bio;
}
