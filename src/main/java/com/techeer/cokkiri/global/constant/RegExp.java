package com.techeer.cokkiri.global.constant;

public class RegExp {
  public static final String PASSWORD_REGEXP =
      "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!~$%^&-+=()])(?=\\S+$).{8,16}$";

  public static final String USERNAME_REGEXP = "^[A-Za-z0-9]{5,20}$";

  public static final String STUDYNAME_REGEXP = "^.{3,20}$";
}
