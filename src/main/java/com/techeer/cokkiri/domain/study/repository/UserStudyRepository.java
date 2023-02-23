package com.techeer.cokkiri.domain.study.repository;

import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.entity.UserStudy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserStudyRepository extends JpaRepository<UserStudy, Long> {
  @Query("SELECT u FROM User u JOIN u.studies us WHERE us.study.id = :studyId")
  List<User> findByStudyId(@Param("studyId") Long studyId);
}
