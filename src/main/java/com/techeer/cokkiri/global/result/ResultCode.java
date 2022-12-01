package com.techeer.cokkiri.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** {행위}_{목적어}_{성공여부} message 는 동사 명사형으로 마무리 */
@Getter
@AllArgsConstructor
public enum ResultCode {

  // 도메인 별로 나눠서 관리(ex: User 도메인)
  // user
  USER_CREATE_SUCCESS("U001", "사용자 생성 성공"),
  ;

  private final String code;
  private final String message;
}
