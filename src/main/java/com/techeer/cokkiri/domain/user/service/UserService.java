package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserNotFoundException;
import com.techeer.cokkiri.domain.user.mapper.UserMapper;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import com.techeer.cokkiri.global.util.PasswordUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordUtil passwordUtil;

  public boolean isDuplicatedUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  public void register(UserDto.RegisterRequest requestDto) {
    User user = userMapper.toEntity(requestDto);
    user.setEncryptedPassword(passwordUtil.encodingPassword(user.getPassword()));
    userRepository.save(user);
  }

  public User findUserById(long id) {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  public User findByUsername(String username) {
    return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
  }
}
