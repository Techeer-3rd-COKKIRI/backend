package com.techeer.cokkiri.domain.comment.exception;

import com.techeer.cokkiri.global.error.ErrorCode;
import com.techeer.cokkiri.global.error.exception.BusinessException;

public class CommentNotFoundException extends BusinessException {
  public CommentNotFoundException() {
    super(ErrorCode.COMMENT_NOT_FOUND_ERROR);
  }
}
