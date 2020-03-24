package com.test.hplus.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;

@Controller
public class RegistrationController {

  @Autowired
  private UserRepository userRepository;

  /**
   * We can bind many objects inside the initBinder.
   *
   * @param binder - converts a string (that cames from 'dateOfBirth' from register.jsp) to date to set on user object
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Date.class, "dateOfBirth",
        new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
  }

  /**
   * use PostMapping to do a post to register a user with a submit and return to login page.
   *
   * @param  Valid          Allows user are used on method if user data come from modelAttribute is valid
   * @param  ModelAttribute receives a user from form with modelAttribute="newuser"
   * @param  user           a user bean
   * @param  model          a transaction bean that dispose the objects on session page
   * @return
   */
  @PostMapping("/registeruser") //
  public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {
    System.out.println("in registration controller");
    System.out.println("user dateBirth: " + user.getDateOfBirth());
    if (result.hasErrors()) {
      return "register";
    }

    userRepository.save(user);
    model.addAttribute("dataSaved", "User registered");
    return "login";
  }
}
