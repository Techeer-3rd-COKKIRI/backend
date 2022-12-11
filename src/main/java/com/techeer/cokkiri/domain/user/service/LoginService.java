package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.entity.User;
import javax.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginService {
  private final HttpSession httpSession;
  private final UserService userService;
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
}
