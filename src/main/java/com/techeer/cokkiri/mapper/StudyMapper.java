package com.techeer.cokkiri.mapper;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.dto.request.CreateStudyRequest;
import com.techeer.cokkiri.dto.response.CreateStudyResponse;

import java.util.List;
import java.util.stream.Collectors;

public class StudyMapper {
    public CreateStudyResponse toDto(Study study) {
        return CreateStudyResponse.builder()

                .build();
    }

    public Study toEntity(CreateStudyRequest dto) {
        Study study = Study.builder()

                .build();

        return study;
    }

    public List<CreateStudyResponse> toDtoList(List<Study> list) {
        return list.stream().map(this::toDto)
                .collect(Collectors.toList());
    }
}
