package com.techeer.cokkiri.domain.comment.dto;

import com.techeer.cokkiri.domain.user.dto.UserCommentInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfo {

    @NotNull
    private String content;
    private Integer likeCount;
    private Integer dislikeCount;
    @NotNull
    private UserCommentInfo userCommentInfo;

}
