package com.techeer.cokkiri.domain.user.exception;

import com.techeer.cokkiri.global.error.ErrorCode;
import com.techeer.cokkiri.global.error.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
  public UserNotFoundException() {
    super(ErrorCode.USER_NOT_FOUND_ERROR);
  }
}
