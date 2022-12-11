package com.techeer.cokkiri.domain.study.mapper;

import static com.techeer.cokkiri.domain.study.dto.StudyDto.*;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class StudyMapper {
  public Response toDto(Study study) {
    return Response.builder().studyName(study.getStudyName()).build();
  }

  public Study toEntity(Request dto, User manager) {
    Study study =
        Study.builder()
            .studyName(dto.getStudyName())
            .studyPassword(dto.getStudyPassword())
            .userLimit(dto.getUserLimit())
            .introduction(dto.getIntroduction())
            .studyCycle(dto.getStudyCycle())
            .startDate(dto.getStartDate())
            .finishDate(dto.getFinishDate())
            .manager(manager)
            .build();

    return study;
  }

  public List<Response> toDtoList(List<Study> list) {
    return list.stream().map(this::toDto).collect(Collectors.toList());
  }
}
