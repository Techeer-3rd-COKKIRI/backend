package com.techeer.cokkiri.domain.study.controller;

import static com.techeer.cokkiri.fixture.StudyFixtures.JAVA_STUDY_FIXTURE;
import static com.techeer.cokkiri.fixture.UserFixtures.STUDY_MANAGER_FIXTURE;
import static com.techeer.cokkiri.global.result.ResultCode.STUDY_CREATE_SUCCESS;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techeer.cokkiri.domain.study.service.StudyService;
import com.techeer.cokkiri.domain.user.service.LoginService;
import com.techeer.cokkiri.fixture.StudyFixtures;
import com.techeer.cokkiri.global.result.ResultResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

@WebMvcTest(StudyController.class)
public class StudyControllerTest {
  @MockBean private StudyService studyService;
  @MockBean private LoginService loginService;
  private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @BeforeEach
  void setUp(WebApplicationContext applicationContext) {
    mockMvc =
        MockMvcBuilders.webAppContextSetup(applicationContext)
            .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
            .build();
  }

  private String toJsonString(Object object) throws JsonProcessingException {
    return objectMapper.writeValueAsString(object);
  }

  @Test
  @DisplayName("스터디 생성 요청을 보내면 스터디가 생성된다.")
  void createStudyTest() throws Exception {
    when(loginService.isUserLogin()).thenReturn(true);
    when(loginService.getLoginUser()).thenReturn(STUDY_MANAGER_FIXTURE);
    when(studyService.isDuplicatedStudy(any())).thenReturn(false);
    when(studyService.createStudy(any(), any())).thenReturn(JAVA_STUDY_FIXTURE);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/studies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(StudyFixtures.JAVA_STUDY_REQUEST)))
        .andExpect(status().isOk())
        .andExpect(content().string(toJsonString(ResultResponse.of(STUDY_CREATE_SUCCESS))))
        .andDo(print());
  }
}
