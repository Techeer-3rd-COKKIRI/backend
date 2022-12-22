package com.techeer.cokkiri.domain.user.repository;

import static com.techeer.cokkiri.fixture.UserFixtures.DEFAULT_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.techeer.cokkiri.domain.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired private UserRepository userRepository;

  @Test
  @DisplayName("username으로 user를 조회할 수 있다.")
  void userExists() {

    User user = DEFAULT_USER;
    userRepository.save(user);

    assertEquals(user.getUsername(), "defaultUser");
  }
}