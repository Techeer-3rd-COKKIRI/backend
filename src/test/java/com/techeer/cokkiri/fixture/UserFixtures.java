package com.techeer.cokkiri.fixture;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;

public class UserFixtures {
  public static final User STUDY_MANAGER_FIXTURE =
      User.builder()
          .username("javaStudyManager")
          .bio("자바를 좋아합니다.")
          .nickname("javaMania")
          .password("qwer123!")
          .build();

  public static final User DEFAULT_USER =
      User.builder()
          .username("DefaultUser1")
          .bio("테스트용 디폴트 유저")
          .nickname("default")
          .password("Test1234!")
          .build();

  public static final UserDto.LoginRequest USER_LOGIN_REQUEST =
      UserDto.LoginRequest.builder()
          .username(DEFAULT_USER.getUsername())
          .password(DEFAULT_USER.getPassword())
          .build();

  public static final UserDto.RegisterRequest USER_REGISTER_REQUEST =
      UserDto.RegisterRequest.builder()
          .username(DEFAULT_USER.getUsername())
          .password(DEFAULT_USER.getPassword())
          .nickname(DEFAULT_USER.getNickname())
          .build();
}
