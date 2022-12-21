package com.techeer.cokkiri.domain.comment.service;

import com.techeer.cokkiri.domain.comment.dto.CommentDto;
import com.techeer.cokkiri.domain.comment.dto.CommentInfo;
import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.comment.exception.CommentNotFoundException;
import com.techeer.cokkiri.domain.comment.mapper.CommentMapper;
import com.techeer.cokkiri.domain.comment.repository.CommentRepository;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentService {

  private final CommentRepository commentRepository;

  private final CommentMapper commentMapper;

  public void registerComment(CommentDto.Request commentDto, User user, Study study) {

    Comment comment = commentMapper.toEntity(commentDto, user, study);

    commentRepository.save(comment);
  }

  public List<CommentInfo> findCommentByStudyWeek(Integer studyWeek) {
    List<Comment> comments =
        commentRepository
            .findCommentByStudyWeek(studyWeek)
            .orElseThrow(CommentNotFoundException::new);
    return commentMapper.toDtoList(comments);
  }
}
