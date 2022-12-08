package com.techeer.cokkiri.global.result;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ResultResponse {

  private String code;
  private String message;
  private Object data;

  public static ResultResponse of(ResultCode resultCode, Object data) {
    return new ResultResponse(resultCode, data);
  }

  public static ResultResponse of(ResultCode resultCode) {
    return new ResultResponse(resultCode, "");
  }

  public ResultResponse(ResultCode resultCode, Object data) {
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
    this.data = data;
  }


}
