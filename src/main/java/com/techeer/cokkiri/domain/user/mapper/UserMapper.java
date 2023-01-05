package com.techeer.cokkiri.domain.user.mapper;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public UserDto.RegisterResponse toDto(User user) {
    return UserDto.RegisterResponse.builder().username(user.getUsername()).build();
  }

  public User toEntity(UserDto.RegisterRequest dto) {
    User user =
        User.builder()
            .username(dto.getUsername())
            .password(dto.getPassword())
            .nickname(dto.getNickname())
            .bio(dto.getBio())
            .build();

    return user;
  }

  public List<UserDto.RegisterResponse> toDtoList(List<User> list) {
    return list.stream().map(this::toDto).collect(Collectors.toList());
  }
}
