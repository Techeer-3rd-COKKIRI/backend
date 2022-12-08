package com.techeer.cokkiri.global.interceptor;

import com.techeer.cokkiri.domain.user.exception.UnAuthorizedAccessException;
import com.techeer.cokkiri.domain.user.service.LoginService;
import com.techeer.cokkiri.global.annotation.LoginRequired;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
// 인터셉터를 통해 로그인 처리 구현
public class LoginInterceptor implements HandlerInterceptor {
  private final LoginService loginService;

  @Override
  // 컨트롤러가 호출되기 전에 실행됨
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws UnAuthorizedAccessException {
    if (isLoginRequiredMethod(handler) && !loginService.isUserLogin()) {
      throw new UnAuthorizedAccessException();
    }
    return true;
  }

  private boolean isLoginRequiredMethod(Object handler) {
    // HandlerMethod: @RequestMapping과 그 하위 어노테이션(@GetMapping 등)이 붙은 메소드의 정보를 추상화한 객체
    // 즉 handler가 매핑된 메소드의 정보고, 그 메소드의 어노테이션에 LoginRequired가 있으면 실행
    return handler instanceof HandlerMethod
        && ((HandlerMethod) handler).hasMethodAnnotation(LoginRequired.class);
  }
}
