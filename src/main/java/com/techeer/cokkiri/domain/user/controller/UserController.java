package com.techeer.cokkiri.domain.user.controller;

import static com.techeer.cokkiri.global.result.ResultCode.*;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserDuplicatedException;
import com.techeer.cokkiri.domain.user.service.LoginService;
import com.techeer.cokkiri.domain.user.service.UserService;
import com.techeer.cokkiri.global.result.ResultCode;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "회원 인증 API")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;
  private final LoginService loginService;

  @ApiOperation(value = "회원가입")
  @PostMapping
  public ResponseEntity<ResultResponse> registration(
      @RequestBody @Valid UserDto.RegisterRequest userRequest) {
    if (userService.isDuplicatedUsername(userRequest.getUsername())) {
      throw new UserDuplicatedException();
    }
    userService.register(userRequest);
    return ResponseEntity.ok(ResultResponse.of(USER_REGISTRATION_SUCCESS));
  }

  @ApiOperation(value = "중복확인")
  @GetMapping("/duplicated/{username}")
  public ResponseEntity<ResultResponse> isDuplicatedUsername(@PathVariable String username) {
    boolean isDuplicated = userService.isDuplicatedUsername(username);

    if (isDuplicated) {
      return ResponseEntity.ok(ResultResponse.of(ResultCode.USER_USERNAME_DUPLICATED, true));
    }
    return ResponseEntity.ok(ResultResponse.of(USER_USERNAME_NOT_DUPLICATED, false));
  }

  @ApiOperation(value = "로그인")
  @PostMapping("/login")
  public ResponseEntity<ResultResponse> login(
      @RequestBody @Valid UserDto.LoginRequest userRequest) {
    boolean isValidUser = loginService.isValidUser(userRequest);

    if (isValidUser) {
      User user = userService.findByUsername(userRequest.getUsername());
      loginService.login(user.getId());
    }
    return ResponseEntity.ok(ResultResponse.of(USER_LOGIN_SUCCESS));
  }
}
