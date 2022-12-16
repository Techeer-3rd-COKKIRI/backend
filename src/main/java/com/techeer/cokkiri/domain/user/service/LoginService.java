package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.dto.UserDto;
import com.techeer.cokkiri.domain.user.entity.User;
import com.techeer.cokkiri.global.util.PasswordUtil;
import javax.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginService {
  private final HttpSession httpSession;
  private final UserService userService;
  private final PasswordUtil passwordUtil;
  public static final String USER_ID = "USER_ID";

  public void login(long id) {
    httpSession.setAttribute(USER_ID, id);
  }

  public void logout() {
    httpSession.removeAttribute(USER_ID);
  }

  public User getLoginUser() {
    return userService.findUserById(getLoginUserId());
  }

  public Long getLoginUserId() {
    return (Long) httpSession.getAttribute(USER_ID);
  }

  public boolean isUserLogin() {
    return getLoginUserId() != null;
  }

  public boolean isValidUser(UserDto.Request userRequest) {
    User user = userService.findUserByUsername(userRequest.getUsername());
    return passwordUtil.isSamePassword(userRequest.getPassword(), user.getPassword());
  }
}
