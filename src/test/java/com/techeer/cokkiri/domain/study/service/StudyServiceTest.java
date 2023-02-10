//package com.techeer.cokkiri.domain.study.service;
//
//import static com.techeer.cokkiri.fixture.StudyFixtures.JAVA_STUDY_FIXTURE;
//import static com.techeer.cokkiri.fixture.StudyFixtures.JAVA_STUDY_REQUEST;
//import static com.techeer.cokkiri.fixture.UserFixtures.STUDY_MANAGER_FIXTURE;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import com.techeer.cokkiri.domain.study.mapper.StudyMapper;
//import com.techeer.cokkiri.domain.study.repository.StudyRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//public class StudyServiceTest {
//  @InjectMocks private StudyService studyService;
//  @Mock private StudyRepository studyRepository;
//  @Mock private StudyMapper studyMapper;
//
//  @Test
//  @DisplayName("DTO를 받아서 Study를 생성했을때 반환되는 Study와 DTO의 값이 같다.")
//  void createStudyTest() {
//    when(studyRepository.save(any())).thenReturn(JAVA_STUDY_FIXTURE);
//    when(studyMapper.toEntity(any(), any())).thenReturn(JAVA_STUDY_FIXTURE);
//    assertEquals(
//        JAVA_STUDY_FIXTURE, studyService.createStudy(JAVA_STUDY_REQUEST, STUDY_MANAGER_FIXTURE));
//  }
//
//  @Test
//  @DisplayName("이미 있는 같은 이름으로 생성된 스터디가 있으면 True가 반환된다.")
//  void isDuplicatedStudyTest() {
//    when(studyRepository.existsByStudyName(any())).thenReturn(true);
//    assertTrue(studyService.isDuplicatedStudy(JAVA_STUDY_FIXTURE.getStudyName()));
//  }
//}
