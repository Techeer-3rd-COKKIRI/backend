package com.techeer.cokkiri.domain.study.mapper;

import static com.techeer.cokkiri.domain.study.dto.StudyDto.*;

import com.techeer.cokkiri.domain.study.dto.StudyDto;
import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class StudyMapper {

  private UserMapper userMapper = new UserMapper();

  public InfoResponse toDto(Study study) {
    return InfoResponse.builder().id(study.getId()).studyName(study.getStudyName()).build();
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

  public StudyDto.FindResponse toDto(Study study, List<User> users) {

    StudyDto.FindResponse studyFindResponse =
        StudyDto.FindResponse.builder()
            .manager(userMapper.toUserDto(study.getManager()))
            .users(userMapper.toFindUserDtoList(users))
            .studyName(study.getStudyName())
            .userLimit(study.getUserLimit())
            .introduction(study.getIntroduction())
            .studyCycle(study.getStudyCycle())
            .finishDate(study.getFinishDate())
            .build();

    return studyFindResponse;
  }

  public List<InfoResponse> toDtoList(List<Study> list) {
    return list.stream().map(this::toDto).collect(Collectors.toList());
  }
}
