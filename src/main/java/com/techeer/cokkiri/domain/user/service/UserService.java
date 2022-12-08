package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserNotFoundException;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserService {
  private final UserRepository userRepository;

  public boolean isDuplicatedUsername(String username) {
    return !userRepository.existsByUsername(username);
  }

  public void register(User user) {
    userRepository.save(user);
  }

  public User findUserById(long id) {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username).orElseThrow(UserNotFoundException::new);
  }

  // 회원 정보가 유효한지 확인
  public boolean isValidUser(UserDto userDto, PasswordEncoder passwordEncoder) {
    User user = findUserByUsername(userDto.getUsername());
    // DTO로 전달된 비밀번호와 DB에 저장된 암호화된 비밀번호가 같은지 확인
    if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
      return true;
    }
    return false;
  }
}
