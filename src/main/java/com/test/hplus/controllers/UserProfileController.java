package com.test.hplus.controllers;

import com.test.hplus.beans.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model) {
        System.out.println("in user profile controler");
        System.out.println("username from session: " + login.getUsername());
        model.addAttribute("username", login.getUsername());
        return "profile";
    }
}