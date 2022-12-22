package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserPasswordWrongException;
import com.techeer.cokkiri.domain.user.mapper.UserMapper;
import com.techeer.cokkiri.domain.user.repository.UserRepository;
import com.techeer.cokkiri.global.util.PasswordUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.techeer.cokkiri.fixture.UserFixtures.DEFAULT_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordUtil passwordUtil;

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginService loginService;



    private User user;
    private UserDto.LoginRequest loginRequest;

    @BeforeEach
    void setup() {
        user = DEFAULT_USER;

        loginRequest =  UserDto.LoginRequest.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Nested
    class loginTest {
        @Test
        @DisplayName("해당 username을 가진 유저가 존재하지 않을 경우 ")
        void userNotExist() {

        }

        @Test
        @DisplayName("username은 존재하나 비밀번호가 다를 경우")
        void wrongPassword() {
            //given
            when(passwordUtil.isSamePassword(any(), any())).thenReturn(false);
            when(userService.findByUsername(any(String.class))).thenReturn(user);

            //then
            assertThrows(UserPasswordWrongException.class, () -> {
                loginService.isValidUser(loginRequest);
            });
        }

        //dto validation 확인로 컨트롤러에서~


    }

//    @Nested
//    class findByUsername {
//        @Test
//        @DisplayName("username으로 조회시 default user가 존재")
//        void userNameExists() {
//            //given
//            User user = DEFAULT_USER;
//            userRepository.save(user);
//
//            //when
//            when(userService.findByUsername(user.getUsername()).thenReturn(user));
//
//            //then
//            assertThat(findByUsernameUser.equals(user));
//
//        }
//
//        @Test
//        @DisplayName("username으로 조회시 해당 user가 존재하지 않으면 UserNotFound가 발생함.")
//        void userNameNotExists() {
//
//        }
//    }



}