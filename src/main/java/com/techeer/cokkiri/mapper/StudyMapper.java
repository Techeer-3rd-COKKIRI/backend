package com.techeer.cokkiri.mapper;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.dto.request.CreateStudyRequest;
import com.techeer.cokkiri.dto.response.CreateStudyResponse;

import java.util.List;
import java.util.stream.Collectors;

public class StudyMapper {
    public CreateStudyResponse toDto(Study study) {
        return CreateStudyResponse.builder()
                .id(study.getId())
                .studyName(study.getStudyName())
                .build();
    }

    public Study toEntity(CreateStudyRequest dto) {
        Study study = Study.builder()
                .manager(dto.getManager())
                .studyName(dto.getStudyName())
                .studyPassword(dto.getStudyPassword())
                .userLimit(dto.getUserLimit())
                .introduction(dto.getIntroduction())
                .studyCycle(dto.getStudyCycle())
                .startDate(dto.getStartDate())
                .finishDate(dto.getFinishDate())
                .build();

        return study;
    }

    public List<CreateStudyResponse> toDtoList(List<Study> list) {
        return list.stream().map(this::toDto)
                .collect(Collectors.toList());
    }
}
