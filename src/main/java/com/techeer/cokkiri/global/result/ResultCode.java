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
  GET_LOGIN_USER_SUCCESS("U006", "로그인 되어있는 회원 조회 성공"),

  // study
  STUDY_CREATE_SUCCESS("S001", "스터디 생성 성공"),
  STUDY_GET_SUCCESS("S002", "스터디 조회 성공"),
  STUDY_PAGING_GET_SUCCESS("S003", "스터디 페이징 조회 성공"),
  USER_STUDY_PAGING_GET_SUCCESS("S004", "유저별 스터디 페이징 조회 성공"),

  // comment
  REGISTER_COMMENT_SUCCESS("C001", "댓글 등록 성공"),
  COMMENT_FIND_SUCCESS("C002", "댓글 찾기 성공"),
  ;

  private final String code;
  private final String message;
}
