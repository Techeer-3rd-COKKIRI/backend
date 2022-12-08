package com.techeer.cokkiri.domain.user.dto;

import com.techeer.cokkiri.domain.user.entity.User;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

  @NotBlank(message = "username을 입력해주세요")
  private String username;

  @Pattern(
      message = "대소문자와 숫자, 특수문자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해야 합니다.",
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$")
  private String password;

  @NotBlank(message = "닉네임을 입력해주세요")
  private String nickname;

  private String imageUrl;
  private String bio;

  public static User toEntity(UserDto userDto, PasswordEncoder passwordEncoder) {
    return User.builder()
        .username(userDto.getUsername())
        .password(passwordEncoder.encode(userDto.getPassword()))
        .nickname(userDto.getNickname())
        .imageUrl(userDto.getImageUrl())
        .bio(userDto.getBio())
        .build();
  }
}
