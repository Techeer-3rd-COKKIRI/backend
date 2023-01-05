package com.techeer.cokkiri.domain.user.exception;

import com.techeer.cokkiri.global.error.ErrorCode;
import com.techeer.cokkiri.global.error.exception.BusinessException;

public class InValidPasswordException extends BusinessException {
  public InValidPasswordException() {
    super(ErrorCode.INVALID_PASSWORD);
  }
}
