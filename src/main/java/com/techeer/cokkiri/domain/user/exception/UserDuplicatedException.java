package com.techeer.cokkiri.domain.user.exception;

import static com.techeer.cokkiri.global.error.ErrorCode.USER_USERNAME_DUPLICATED;

import com.techeer.cokkiri.global.error.exception.BusinessException;

public class UserDuplicatedException extends BusinessException {
  public UserDuplicatedException() {
    super(USER_USERNAME_DUPLICATED);
  }
}
