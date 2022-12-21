package com.techeer.cokkiri.domain.study.repository;

import static com.techeer.cokkiri.fixture.StudyFixtures.JAVA_STUDY_FIXTURE;
import static com.techeer.cokkiri.fixture.UserFixtures.STUDY_MANAGER_FIXTURE;
import static org.junit.jupiter.api.Assertions.*;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)
public class StudyRepositoryTest {
  @Autowired private StudyRepository studyRepository;
  @Autowired private UserRepository userRepository;
  private Study study = JAVA_STUDY_FIXTURE;
  private User user = STUDY_MANAGER_FIXTURE;

  @BeforeEach
  void setting() {
    userRepository.save(user);
    studyRepository.save(study);
  }

  @Test
  @DisplayName("스터디의 이름으로 스터디가 있는지 확인할 수 있다.")
  void checkExistsByStudyName() {
    assertTrue(studyRepository.existsByStudyName(study.getStudyName()));
    assertFalse(studyRepository.existsByStudyName("wrong_name"));
  }
}
