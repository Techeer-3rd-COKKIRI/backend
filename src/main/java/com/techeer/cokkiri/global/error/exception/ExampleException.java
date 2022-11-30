package com.techeer.cokkiri.global.error.exception;

import com.techeer.cokkiri.global.error.ErrorCode;

public class ExampleException extends BusinessException {
  public ExampleException() {
    super(ErrorCode.EXAMPLE_USER_ERROR);
  }
}
