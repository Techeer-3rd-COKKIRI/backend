package com.techeer.cokkiri.domain.comment.dto;

import lombok.*;

import javax.validation.constraints.NotNull;



public class CommentDto {

    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class Request {

        @NotNull
        private Integer studyWeek;
        @NotNull
        private String content;
        @NotNull
        private Long studyId;
    }

}
