package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exceptions.ApplicationException;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/login")
  public String login(@ModelAttribute("login") Login login) {
    User user = userRepository.searchByName(login.getUsername());
    if (user == null) {
      throw new ApplicationException("User not found");
    }
    return "search";
  }

  /**
   * With this annotation and specific class to throw an exception each time wich an exception is throwing this method
   * returns error.
   */
//  @ExceptionHandler(ApplicationException.class)
//  public String handleException() {
//    System.out.println("in exception handler login controller");
//    return "error";
//  }
}
