package com.techeer.cokkiri.domain.study.service;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.study.dto.request.CreateStudyRequest;
import com.techeer.cokkiri.domain.study.mapper.StudyMapper;
import com.techeer.cokkiri.domain.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyService {

  private final StudyRepository studyRepository;
  private final StudyMapper studyMapper;

  public Study createStudy(CreateStudyRequest requestDto) { // 스터디 등록
    //        if(studyRepository.existsByAccountId(dto.getAccountId())) { //유효성 검사
    //            throw new EntityExistsException();
    //        }
    Study study = studyMapper.toEntity(requestDto);
    Study createdStudy = studyRepository.save(study);

    return createdStudy;
  }
}
