package com.techeer.cokkiri.controller;

import com.techeer.cokkiri.domain.study.entity.Study;
import com.techeer.cokkiri.dto.request.CreateStudyRequest;
import com.techeer.cokkiri.dto.response.CreateStudyResponse;
import com.techeer.cokkiri.mapper.StudyMapper;
import com.techeer.cokkiri.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/study")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;
    private final StudyMapper studyMapper;

    @PostMapping
    public ResponseEntity<CreateStudyResponse> createStudy(@RequestBody CreateStudyRequest requestDto) {
        CreateStudyResponse responseDto = studyMapper.toDto(studyService.createStudy(requestDto));
        return ResponseEntity.ok(responseDto);
    }
}
