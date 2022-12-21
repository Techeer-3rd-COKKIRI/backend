package com.techeer.cokkiri.fixture;

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
          .username("defaultUser")
          .bio("테스트용 디폴트 유저")
          .nickname("default")
          .password("Test1234!")
          .build();
}
