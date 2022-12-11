package com.techeer.cokkiri.domain.study.exception;

import com.techeer.cokkiri.global.error.ErrorCode;
import com.techeer.cokkiri.global.error.exception.BusinessException;

public class StudyDuplicationException extends BusinessException {
  public StudyDuplicationException() {
    super(ErrorCode.STUDY_DUPLICATION_ERROR);
  }
}
