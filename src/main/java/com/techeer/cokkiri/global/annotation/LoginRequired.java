package com.techeer.cokkiri.global.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/** 로그인 상태인지 체크해주는 어노테이션 */
public @interface LoginRequired {}
