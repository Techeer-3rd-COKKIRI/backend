package com.techeer.cokkiri.fixture;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.entity.Comment;

public class CommentFixtures {

  public static final Comment COMMENT_FIXTURE =
      Comment.builder()
          .content("안녕하세요!")
          .studyWeek(1)
          .user(UserFixtures.STUDY_MANAGER_FIXTURE)
          .study(StudyFixtures.JAVA_STUDY_FIXTURE)
          .build();

  public static final CommentDto.CreateRequest COMMENT_REQUEST =
      CommentDto.CreateRequest.builder()
          .studyWeek(1)
          .content("안녕하세요")
          .studyId(StudyFixtures.JAVA_STUDY_FIXTURE.getId())
          .build();
}
