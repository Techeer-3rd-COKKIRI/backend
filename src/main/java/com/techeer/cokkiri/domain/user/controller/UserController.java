package com.techeer.cokkiri.domain.user.controller;

import static com.techeer.cokkiri.domain.user.controller.UserController.USER_API_URI;
import static com.techeer.cokkiri.global.result.ResultCode.USER_REGISTRATION_SUCCESS;

import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.domain.user.service.UserService;
import com.techeer.cokkiri.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping(USER_API_URI)
public class UserController {
  public static final String USER_API_URI = "/api/users";

  private final UserService userService;

  @PostMapping
  public ResponseEntity<ResultResponse> registration(@RequestBody User user) {
    userService.registrationUser(user);
    return ResponseEntity.ok(ResultResponse.of(USER_REGISTRATION_SUCCESS));
  }
}
