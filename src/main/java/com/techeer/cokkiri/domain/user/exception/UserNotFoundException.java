package com.techeer.cokkiri.domain.user.exception;

import static com.techeer.cokkiri.global.error.ErrorCode.USER_NOT_FOUND_ERROR;

import com.techeer.cokkiri.global.error.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
  public UserNotFoundException() {
    super(USER_NOT_FOUND_ERROR);
  }
}
