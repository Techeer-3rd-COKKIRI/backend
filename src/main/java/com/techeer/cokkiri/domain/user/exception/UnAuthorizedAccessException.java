package com.techeer.cokkiri.domain.user.exception;

import static com.techeer.cokkiri.global.error.ErrorCode.UNAUTHORIZED_ACCESS_ERROR;

import com.techeer.cokkiri.global.error.exception.BusinessException;

public class UnAuthorizedAccessException extends BusinessException {
  public UnAuthorizedAccessException() {
    super(UNAUTHORIZED_ACCESS_ERROR);
  }
}
