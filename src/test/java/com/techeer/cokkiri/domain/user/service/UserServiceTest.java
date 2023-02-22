package com.techeer.cokkiri.domain.user.service;

import static com.techeer.cokkiri.fixture.UserFixtures.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.techeer.cokkiri.domain.user.mapper.UserMapper;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import com.techeer.cokkiri.global.util.PasswordUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  @Mock private UserRepository userRepository;
  @Mock private UserMapper userMapper;
  @Mock private PasswordUtil passwordUtil;
  @InjectMocks private UserService userService;

  @Test
  @DisplayName("이미 있는 같은 username이 있다면 True 반환. 즉 회원가입 실패")
  void isDuplicatedUsernameTest() {
    when(userRepository.existsByUsername(any())).thenReturn(true);
    assertTrue(userService.isDuplicatedUsername(DEFAULT_USER.getUsername()));
  }

  @Test
  @DisplayName("회원가입 성공")
  void registerTest() {
    when(userRepository.save(any())).thenReturn(DEFAULT_USER);
    when(userMapper.toEntity(any())).thenReturn(DEFAULT_USER);
    assertEquals(DEFAULT_USER, userService.register(USER_REGISTER_REQUEST));
  }
}
