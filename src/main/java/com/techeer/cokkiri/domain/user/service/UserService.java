package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserNotFoundException;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class UserService {
  private final UserRepository userRepository;

  public void registrationUser(User user) {
    userRepository.save(user);
  }

  public User findUserById(long id) {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }
}
