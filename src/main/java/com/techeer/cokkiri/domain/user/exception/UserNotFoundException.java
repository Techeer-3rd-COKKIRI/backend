package com.techeer.cokkiri.domain.user.exception;

import com.techeer.cokkiri.global.error.exception.BusinessException;

import static com.techeer.cokkiri.global.error.ErrorCode.USER_NOT_FOUND_ERROR;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(USER_NOT_FOUND_ERROR);
    }
}
