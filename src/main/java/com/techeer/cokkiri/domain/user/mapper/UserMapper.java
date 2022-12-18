package com.techeer.cokkiri.domain.user.mapper;

import com.techeer.cokkiri.domain.user.dto.UserRegisterRequest;
import com.techeer.cokkiri.domain.user.entity.User;

public class UserMapper {
  public static User toEntity(UserRegisterRequest userRegisterRequest) {
    return User.builder()
        .username(userRegisterRequest.getUsername())
        .password(userRegisterRequest.getPassword())
        .nickname(userRegisterRequest.getNickname())
        .bio(userRegisterRequest.getBio())
        .build();
  }
}
