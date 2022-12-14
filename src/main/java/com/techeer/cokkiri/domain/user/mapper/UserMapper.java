package com.techeer.cokkiri.domain.user.mapper;

import com.techeer.cokkiri.domain.user.dto.UserRegisterRequest;
import com.techeer.cokkiri.domain.user.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    public static User toEntity(UserRegisterRequest userRegisterRequest) {
        return User.builder()
                .username(userRegisterRequest.getUsername())
                .password(userRegisterRequest.getPassword())
                .nickname(userRegisterRequest.getNickname())
                .imageUrl(userRegisterRequest.getImageUrl())
                .bio(userRegisterRequest.getBio())
                .build();
    }
}
