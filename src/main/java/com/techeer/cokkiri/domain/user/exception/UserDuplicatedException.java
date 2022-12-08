package com.techeer.cokkiri.domain.user.exception;

import com.techeer.cokkiri.global.error.exception.BusinessException;

import static com.techeer.cokkiri.global.error.ErrorCode.USER_USERNAME_DUPLICATED;

public class UserDuplicatedException extends BusinessException {
    public UserDuplicatedException() {
        super(USER_USERNAME_DUPLICATED);
    }
}