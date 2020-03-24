package com.test.hplus.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice ataches this controller to all controllers at application. In this case we'll attache the
 * exceptions.
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

  @ExceptionHandler(ApplicationException.class)
  public String handleException() {
    System.out.println("in global exception handler controller");
    return "error";
  }
}
