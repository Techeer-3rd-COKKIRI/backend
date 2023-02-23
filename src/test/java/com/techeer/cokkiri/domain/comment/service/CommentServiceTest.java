package com.techeer.cokkiri.domain.comment.service;

import static com.techeer.cokkiri.fixture.CommentFixtures.COMMENT_FIXTURE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.techeer.cokkiri.domain.comment.mapper.CommentMapper;
import com.techeer.cokkiri.domain.comment.repository.CommentRepository;
import com.techeer.cokkiri.fixture.CommentFixtures;
import com.techeer.cokkiri.fixture.StudyFixtures;
import com.techeer.cokkiri.fixture.UserFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

  @InjectMocks private CommentService commentService;

  @Mock private CommentRepository commentRepository;

  @Mock private CommentMapper commentMapper;

  @Test
  @DisplayName("DTO를 받아서 Comment 생성했을때 반환되는 Comment와 DTO의 값이 같다.")
  void createCommentTest() {
    when(commentRepository.save(any())).thenReturn(COMMENT_FIXTURE);
    when(commentMapper.toEntity(any(), any(), any())).thenReturn(COMMENT_FIXTURE);
    assertEquals(
        COMMENT_FIXTURE,
        commentService.registerComment(
            CommentFixtures.COMMENT_REQUEST,
            UserFixtures.STUDY_MANAGER_FIXTURE,
            StudyFixtures.JAVA_STUDY_FIXTURE));
  }
}
