package com.techeer.cokkiri.domain.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCommentInfo {

    private String userName;
    private Long userId;
    private String imageUrl;

}
