package com.techeer.cokkiri.domain.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

public class UserDto {

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {
        @NotBlank private String username;
        @NotBlank private String password;
    }

}
