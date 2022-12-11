package com.techeer.cokkiri.domain.study.repository;

import com.techeer.cokkiri.domain.study.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
  boolean existsByStudyName(String studyName);
}
