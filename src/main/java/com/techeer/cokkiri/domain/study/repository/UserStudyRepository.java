package com.techeer.cokkiri.domain.study.repository;

import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.entity.UserStudy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStudyRepository extends JpaRepository<UserStudy, Long> {
    List<User> findByStudyId(Long studyId);
}
