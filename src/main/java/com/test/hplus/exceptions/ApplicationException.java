package com.test.hplus.exceptions;

public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 7597289382141142379L;

  public ApplicationException(String message) {
    super(message);
  }

}
