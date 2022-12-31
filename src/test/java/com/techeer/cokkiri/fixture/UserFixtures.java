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
}
