package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.test.hplus.beans.User;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String goHome() {
    System.out.println("inside home controller");
    return "index";
  }

  @GetMapping("/goToSearch")
  public String goToSearch() {
    System.out.println("going to search page");
    return "search";
  }

  @GetMapping("/goToLogin")
  public String goToLogin() {
    System.out.println("going to login page");
    return "login";
  }

  @GetMapping("/goToRegistration")
  public String goToRegistration() {
    System.out.println("going to registration page");
    return "register";
  }

}
