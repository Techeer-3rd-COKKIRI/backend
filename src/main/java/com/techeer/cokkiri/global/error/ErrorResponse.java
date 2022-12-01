package com.techeer.cokkiri.global.error;

import lombok.*;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
  private String businessCode;
  private String errorMessage;
  private List<FieldError> errors;

  private ErrorResponse(ErrorCode code, List<FieldError> fieldErrors) {
    this.businessCode = code.getCode();
    this.errorMessage = code.getMessage();
    this.errors = fieldErrors;
  }

  private ErrorResponse(ErrorCode code) {
    this.businessCode = code.getCode();
    this.errorMessage = code.getMessage();
    this.errors = new ArrayList<>();
  }

  public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
    return new ErrorResponse(code, FieldError.of(bindingResult));
  }

  public static ErrorResponse of(ErrorCode code) {
    return new ErrorResponse(code);
  }

  @Getter
  @AllArgsConstructor
  public static class FieldError {
    private String field;
    private String value;
    private String reason;

    private static List<FieldError> of(final BindingResult bindingResult) {
      final List<org.springframework.validation.FieldError> fieldErrors =
          bindingResult.getFieldErrors();
      return fieldErrors.stream()
          .map(
              error ->
                  new FieldError(
                      error.getField(),
                      error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                      error.getDefaultMessage()))
          .collect(Collectors.toList());
    }
  }
}
