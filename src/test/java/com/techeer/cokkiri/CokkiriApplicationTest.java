package com.techeer.cokkiri;

import com.techeer.cokkiri.domain.example.domain.entity.Study;
import com.techeer.cokkiri.repository.StudyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CokkiriApplicationTest {

  @Autowired
  StudyRepository studyRepository;

  @Test
  void contextLoads() {}

  @Test
  void addStudy() {
    LocalDate startDate = LocalDate.of(2022, 6, 19);
    LocalDate finishDate = LocalDate.of(2022, 12, 19);

    Study study = Study.builder()
            .managerId(123L)
            .studyName("cokkiri")
            .studyPassword("password")
            .userLimit(7)
            .introduction("java study")
            .studyCycle(7)
            .startDate(startDate)
            .finishDate(finishDate)
            .build();

    Study savedStudy = studyRepository.save(study);
    assertEquals("cokkiri",(studyRepository.findById(savedStudy.getId())).get().getStudyName());
  }
}
