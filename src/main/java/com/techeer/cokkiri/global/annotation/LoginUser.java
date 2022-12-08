package com.techeer.cokkiri.global.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/** 로그인 된 사용자 정보를 바인딩 해주는 어노테이션 */
public @interface LoginUser {}
