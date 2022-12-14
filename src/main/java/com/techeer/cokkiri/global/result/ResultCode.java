package com.techeer.cokkiri.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {행위}_{목적어}_{성공여부} message 는 동사 명사형으로 마무리 */
@Getter
@AllArgsConstructor
public enum ResultCode {

  // 도메인 별로 나눠서 관리(ex: User 도메인)
  // user
  USER_REGISTRATION_SUCCESS("U001", "사용자 등록 성공"),
  USER_USERNAME_DUPLICATED("U002", "회원 아이디 중복"),
  USER_USERNAME_NOT_DUPLICATED("U003", "회원 아이디 중복되지 않음"),
  USER_LOGIN_SUCCESS("U004", "회원 로그인 성공"),
  USER_LOGOUT_SUCCESS("U005", "회원 로그아웃 성공"),

  // study
  STUDY_CREATE_SUCCESS("S001", "스터디 생성 성공")
  ;

  private final String code;
  private final String message;
}
