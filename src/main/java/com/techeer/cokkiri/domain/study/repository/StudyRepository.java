package com.techeer.cokkiri.domain.study.repository;

import com.techeer.cokkiri.domain.study.entity.Study;
import java.util.Optional;

import com.techeer.cokkiri.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long>, StudyCustomRepository {
  boolean existsByStudyName(String studyName);

  Optional<Study> findById(Long studyId);
}
