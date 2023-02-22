package com.techeer.cokkiri.domain.user.controller;

import static com.techeer.cokkiri.fixture.UserFixtures.*;
import static com.techeer.cokkiri.global.result.ResultCode.USER_REGISTRATION_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

import static com.techeer.cokkiri.global.result.ResultCode.USER_LOGIN_SUCCESS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.techeer.cokkiri.domain.user.controller.UserController;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.service.LoginService;
import com.techeer.cokkiri.domain.user.service.UserService;
import com.techeer.cokkiri.global.result.ResultResponse;
import com.techeer.cokkiri.global.util.JsonUtil;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
public class UserControllerTest {

    private final JsonUtil jsonUtil = new JsonUtil();

    @MockBean UserService userService;

    @MockBean LoginService loginService;

    @Mock User mockUser;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext applicationContext) {
        mockMvc =
                MockMvcBuilders.webAppContextSetup(applicationContext)
                        .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                        .build();
    }

    // 미완성 테스트 - login메소드 오류
    @Test
    @DisplayName("로그인에 성공할 경우 ResultResponse")
    void loginTest() throws Exception {
        // given - 회원가입
        when(loginService.isValidPassword(any())).thenReturn(true);
        when(userService.findByUsername(any())).thenReturn(mockUser);
        when(mockUser.getId()).thenReturn(1L);

        mockMvc
                .perform(
                        post("/api/v1/users/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonUtil.toJsonString(USER_LOGIN_REQUEST)))
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers.content()
                                .string(jsonUtil.toJsonString(ResultResponse.of(USER_LOGIN_SUCCESS))))
                .andDo(print()); // 전체 메시지 확인
        System.out.println(content());
    }

    @Test
    @DisplayName("회원가입 테스트")
    void registerTest() throws Exception {
        when(userService.isDuplicatedUsername(any())).thenReturn(false);
        when(userService.register(any())).thenReturn(DEFAULT_USER);

        mockMvc
                .perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonUtil.toJsonString(USER_REGISTER_REQUEST)))
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers.content()
                                .string(jsonUtil.toJsonString(ResultResponse.of(USER_REGISTRATION_SUCCESS))))
                .andDo(print()); // 전체 메시지 확인
        System.out.println(content());
    }
}