package com.techeer.cokkiri.domain.user.controller;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.InValidPasswordException;
import com.techeer.cokkiri.domain.user.exception.UserDuplicatedException;
import com.techeer.cokkiri.domain.user.mapper.UserMapper;
import com.techeer.cokkiri.domain.user.service.LoginService;
import com.techeer.cokkiri.domain.user.service.UserService;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import com.techeer.cokkiri.global.annotation.LoginUser;
import com.techeer.cokkiri.global.result.ResultCode;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import static com.techeer.cokkiri.global.result.ResultCode.*;

@Api(tags = "회원 인증 API")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;
  private final LoginService loginService;
  private final UserMapper userMapper;

  @ApiOperation(value = "회원가입")
  @PostMapping
  public ResponseEntity<ResultResponse> registration(
      @RequestBody @Valid UserDto.RegisterRequest registerRequest) {
    if (userService.isDuplicatedUsername(registerRequest.getUsername())) {
      throw new UserDuplicatedException();
    }
    userService.register(registerRequest);
    return ResponseEntity.ok(ResultResponse.of(USER_REGISTRATION_SUCCESS));
  }

  @ApiOperation(value = "중복확인")
  @GetMapping("/duplicated/{username}")
  public ResponseEntity<ResultResponse> isDuplicatedUsername(@PathVariable String username) {
    if (userService.isDuplicatedUsername(username)) {
      return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_USERNAME_DUPLICATED, true));
    }
    return ResponseEntity.ok(ResultResponse.of(USER_USERNAME_NOT_DUPLICATED, false));
  }

  @ApiOperation(value = "로그인")
  @PostMapping("/login")
  public ResponseEntity<ResultResponse> login(
      @RequestBody @Valid UserDto.LoginRequest loginRequest) {
    if (!loginService.isValidUser(loginRequest)) {
      throw new InValidPasswordException();
    }

    UserDto.RegisterResponse registerResponse = userService.getUserRegisterDtoByUsername(loginRequest.getUsername());
    loginService.login(registerResponse.getId());
    return ResponseEntity.ok(ResultResponse.of(USER_LOGIN_SUCCESS, registerResponse));
  }

  @ApiOperation(value = "로그인 사용자 정보 조회")
  @GetMapping("/login-user")
  @LoginRequired
  public ResponseEntity<ResultResponse> getLoginUserInfo(@ApiIgnore @LoginUser User loginUser) {
    UserDto.RegisterResponse registerResponse = userMapper.toDto(loginUser);
    return ResponseEntity.ok(ResultResponse.of(GET_LOGIN_USER_SUCCESS, registerResponse));
  }

}
