package com.techeer.cokkiri.domain.study.service;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.study.exception.StudyNotFoundException;
import com.techeer.cokkiri.domain.study.mapper.StudyMapper;
import com.techeer.cokkiri.domain.study.repository.StudyRepository;
import com.techeer.cokkiri.domain.study.repository.UserStudyRepository;
import com.techeer.cokkiri.domain.user.entity.User;
import java.util.List;

import com.techeer.cokkiri.domain.user.entity.UserStudy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class StudyService {

  private final StudyRepository studyRepository;
  private final UserStudyRepository userStudyRepository;
  private final StudyMapper studyMapper;

  public Study createStudy(StudyDto.CreateRequest requestDto, User loginUser) { // 스터디 등록
    Study study = studyMapper.toEntity(requestDto, loginUser);
    Study createdStudy = studyRepository.save(study);
    UserStudy userStudy = UserStudy.builder().study(createdStudy).user(loginUser).build();
    userStudyRepository.save(userStudy);

    return createdStudy;
  }

  public boolean isDuplicatedStudy(String studyName) {
    return studyRepository.existsByStudyName(studyName);
  }

  public Study findByStudyId(Long studyId) {
    Study study = studyRepository.findById(studyId).orElseThrow(StudyNotFoundException::new);

    return study;
  }

  public StudyDto.FindResponse findStudyDtoById(Long studyId) {

    Study study = studyRepository.findById(studyId).orElseThrow(StudyNotFoundException::new);
    List<User> studyMembers = userStudyRepository.findByStudyId(studyId);
    StudyDto.FindResponse studyFindResponse = studyMapper.toDto(study, studyMembers);

    return studyFindResponse;
  }

  public List<StudyDto.InfoResponse> getStudyListWithPaging(PageRequest pageRequest) {
    Page<Study> studyPages = studyRepository.findAll(pageRequest);
    return studyMapper.toDtoList(studyPages).getContent();
  }

  public List<StudyDto.InfoResponse> getStudyListByUserIdWithPaging(
      Long userId, PageRequest pageRequest) {
    Page<Study> studyPages = studyRepository.getUserStudy(userId, pageRequest);
    return studyMapper.toDtoList(studyPages).getContent();
  }
}
