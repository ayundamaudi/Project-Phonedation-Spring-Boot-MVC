package com.bca.controllers;

import com.bca.dto.UserForm;
import com.bca.entities.User;
import com.bca.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

  @Autowired
  private AuthService service;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  // @PostMapping("/login")
  // public String signin(LoginForm form) {
  // service.signin(form.getEmail(), form.getPassword());
  // return "redirect:/";
  // }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/register")
  public String signup(UserForm form) {
    service.signup(new User());
    return "redirect:/";
  }

  @PostMapping("/logout")
  public String signout() {
    return "redirect:/";
  }
}
