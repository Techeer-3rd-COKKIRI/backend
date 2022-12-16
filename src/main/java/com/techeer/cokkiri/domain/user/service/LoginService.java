package com.techeer.cokkiri.domain.user.service;

import com.techeer.cokkiri.domain.user.dto.UserDto;
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

  public boolean isValidUser(UserDto .Request userRequest) {

    //username을 가지고 찾아서 password를 비교하고 맞으면 true 리턴

      User user = userService.findUserByUsername(userRequest.getUsername());
      return true;
          //    passwordEncoder.matches(userRequest.getPassword(), user.getPassword());


  }
}
