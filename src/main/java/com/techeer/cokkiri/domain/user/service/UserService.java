package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.dto.UserRegisterRequest;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserNotFoundException;
import com.techeer.cokkiri.domain.user.mapper.UserMapper;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import com.techeer.cokkiri.global.util.PasswordUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserService {
  private final UserRepository userRepository;
  private final PasswordUtil passwordUtil;

  public boolean isDuplicatedUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  public void register(UserRegisterRequest userRegisterRequest) {
    User user = UserMapper.toEntity(userRegisterRequest);
    user.setEncryptedPassword(passwordUtil.encodingPassword(user.getPassword()));
    userRepository.save(user);
  }

  public User findUserById(long id) {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username).orElseThrow(UserNotFoundException::new);
  }
}
