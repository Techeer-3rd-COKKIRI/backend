package com.techeer.cokkiri.domain.user.controller;

import static com.techeer.cokkiri.domain.user.controller.UserController.USER_API_URI;
import static com.techeer.cokkiri.global.result.ResultCode.USER_LOGIN_SUCCESS;
import static com.techeer.cokkiri.global.result.ResultCode.USER_REGISTRATION_SUCCESS;
import static com.techeer.cokkiri.global.result.ResultCode.USER_USERNAME_NOT_DUPLICATED;

import com.techeer.cokkiri.domain.user.dto.UserRegisterRequest;
import com.techeer.cokkiri.domain.user.exception.UserDuplicatedException;
import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
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
      @RequestBody @Valid UserRegisterRequest userRegisterRequest) {
    if (userService.isDuplicatedUsername(userRegisterRequest.getUsername())) {
      throw new UserDuplicatedException();
    }
    userService.register(userRegisterRequest);
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

  @PostMapping
  public ResponseEntity<ResultResponse> login(@RequestBody UserDto.Request userRequest) {
    //유효한 id와 비밀번호인지 db에 존재여부 체크 - 유효하지 않으면 로그인실패 exception

    //유효한 멤버면 로그인시킴 - db에서 username과 비번으로 id찾아서로그인?

    return ResponseEntity.ok(ResultResponse.of(USER_LOGIN_SUCCESS));
  }
}
