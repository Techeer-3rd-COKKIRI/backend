package com.techeer.cokkiri.global.constant;


public class RegExp {
  public static final String PASSWORD_REGEXP =
      "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$";
}
