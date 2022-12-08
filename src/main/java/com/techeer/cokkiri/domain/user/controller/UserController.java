package com.techeer.cokkiri.domain.user.controller;

import static com.techeer.cokkiri.domain.user.controller.UserController.USER_API_URI;
import static com.techeer.cokkiri.global.result.ResultCode.USER_REGISTRATION_SUCCESS;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.exception.UserDuplicatedException;
import com.techeer.cokkiri.domain.user.service.UserService;
import com.techeer.cokkiri.global.result.ResultResponse;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Api(tags = "회원 인증 API")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping(USER_API_URI)
public class UserController {
  public static final String USER_API_URI = "/api/v1/users";

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping
  public ResponseEntity<ResultResponse> registration(@RequestBody @Valid UserDto userDto) {
    if (userService.isDuplicatedUsername(userDto.getUsername())) {
      throw new UserDuplicatedException();
    }
    User user = UserDto.toEntity(userDto, passwordEncoder);
    userService.register(user);
    return ResponseEntity.ok(ResultResponse.of(USER_REGISTRATION_SUCCESS));
  }
}
