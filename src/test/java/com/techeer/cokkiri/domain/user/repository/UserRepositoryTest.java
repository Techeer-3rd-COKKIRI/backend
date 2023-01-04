package com.techeer.cokkiri.domain.user.repository;

import static com.techeer.cokkiri.fixture.UserFixtures.DEFAULT_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.techeer.cokkiri.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired private UserRepository userRepository;

  private User user;

  @BeforeEach
  void saveUser() {}

  @Test
  @DisplayName("user의 존재여부를 username으로 확인한다.")
  void existsByUsername() {
    user = DEFAULT_USER;
    userRepository.save(user);
    assertTrue(userRepository.existsByUsername(user.getUsername()));
  }

  @Test
  @DisplayName("username으로 user를 찾는다.")
  void findByUsername() {
    // given
    user = DEFAULT_USER;
    user = userRepository.save(user);
    User savedUser = userRepository.findByUsername(user.getUsername()).orElseThrow();

    // then
    assertEquals(user, savedUser);
  }
}
