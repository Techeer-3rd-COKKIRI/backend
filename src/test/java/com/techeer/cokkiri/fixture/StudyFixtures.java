package com.techeer.cokkiri.fixture;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.study.entity.Study;

import static com.techeer.cokkiri.domain.study.constant.StudyConstants.*;
import static com.techeer.cokkiri.fixture.UserFixtures.STUDY_MANAGER_FIXTURE;

public class StudyFixtures {
  public static final String JAVA_STUDY_NAME = "자바 스터디";

  public static final Study JAVA_STUDY_FIXTURE =
      Study.builder()
          .manager(STUDY_MANAGER_FIXTURE)
          .studyName(JAVA_STUDY_NAME)
          .studyPassword(DEFAULT_PASSWORD)
          .userLimit(DEFAULT_USER_LIMIT)
          .introduction(DEFAULT_INTRODUCTION)
          .studyCycle(DEFAULT_STUDY_CYCLE)
          .startDate(DEFAULT_START_DATE)
          .finishDate(DEFAULT_FINISH_DATE)
          .build();

  public static final StudyDto.Request JAVA_STUDY_REQUEST =
      StudyDto.Request.builder().studyName(JAVA_STUDY_NAME).build();
}
