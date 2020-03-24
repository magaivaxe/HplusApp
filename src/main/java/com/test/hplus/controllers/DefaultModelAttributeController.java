package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Available this modelAttributes to all application controllers when they are called by the mappings
 */
@ControllerAdvice
public class DefaultModelAttributeController {

  /**
   * See register.jsp line 42
   *
   * @return a user to the jsp form attribute(modelAttribute="newuser").
   */
  @ModelAttribute("newuser")
  public User getDefaultUser() {
    return new User();
  }

  /**
   * See login.jsp line 35
   *
   * @return a login to the jsp form attribute(modelAttribute="login").
   */
  @ModelAttribute("login")
  public Login getDefaultLongin() {
    return new Login();
  }

  /**
   *
   * @return a gender list to jsp select attribute as a session atribute (transactionBean) items="${genderItems}".
   */
  @ModelAttribute("genderItems")
  public List<String> getGenderItems() {
    return Arrays.asList(new String[]{"Male", "Female", "Other"});
  }

}
