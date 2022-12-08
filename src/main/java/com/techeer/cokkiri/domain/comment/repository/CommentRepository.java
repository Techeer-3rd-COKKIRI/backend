package com.techeer.cokkiri.domain.comment.repository;

import com.techeer.cokkiri.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
