package com.techeer.cokkiri.domain.study.repository;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRepository extends JpaRepository<Study, Long> {
  boolean existsByStudyName(String studyName);

  boolean existsById(Long studyId);
  Optional<Study> findUserById(Long id);
}
