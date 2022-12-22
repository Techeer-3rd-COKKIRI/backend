package com.techeer.cokkiri.domain.user.exception;

import com.techeer.cokkiri.global.error.ErrorCode;
import com.techeer.cokkiri.global.error.exception.BusinessException;

public class UserPasswordWrongException extends BusinessException {
    public UserPasswordWrongException() {
        super(ErrorCode.USER_PASSWORD_NOT_MATCH);
    }
}
