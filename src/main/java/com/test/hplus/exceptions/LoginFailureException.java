package com.test.hplus.exceptions;

public class LoginFailureException extends Exception {

  private static final long serialVersionUID = 2609111901122227736L;

  public LoginFailureException(String message) {
    super(message);
  }
}
