package com.techeer.cokkiri.domain.study.exception;

import com.techeer.cokkiri.global.error.ErrorCode;
import com.techeer.cokkiri.global.error.exception.BusinessException;

public class StudyNotFoundException extends BusinessException {

    public StudyNotFoundException() {
        super(ErrorCode.STUDY_NOT_FOUND_ERROR);
    }
}
