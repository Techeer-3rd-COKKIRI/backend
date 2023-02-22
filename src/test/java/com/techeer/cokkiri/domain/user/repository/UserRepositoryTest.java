package com.techeer.cokkiri.domain.user.repository;

import static com.techeer.cokkiri.fixture.UserFixtures.DEFAULT_USER;
import static org.junit.jupiter.api.Assertions.*;

import com.techeer.cokkiri.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {
  @Autowired private UserRepository userRepository;

  private User user = DEFAULT_USER;

  @BeforeEach
  void saveUser() {
    user = userRepository.save(user);
  }

  @Test
  @DisplayName("user의 존재여부를 username으로 확인한다.")
  void existsByUsername() {
    assertTrue(userRepository.existsByUsername(user.getUsername()));
    assertFalse(userRepository.existsByUsername("no_user"));
  }

  @Test
  @DisplayName("username으로 user를 찾는다.")
  void findByUsername() {
    User savedUser = userRepository.findByUsername(user.getUsername()).orElseThrow();

    assertEquals(user, savedUser);
  }
}
