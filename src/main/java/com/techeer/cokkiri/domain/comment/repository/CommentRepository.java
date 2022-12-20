package com.techeer.cokkiri.domain.comment.repository;

import com.techeer.cokkiri.domain.comment.entity.Comment;
import com.techeer.cokkiri.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findCommentByStudyWeek(Integer studyWeek);


}
