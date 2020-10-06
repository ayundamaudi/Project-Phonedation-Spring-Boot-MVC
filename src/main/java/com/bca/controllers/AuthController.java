package com.bca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String signin() {
    return "redirect:/";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/register")
  public String signup() {
    return "redirect:/";
  }

  @PostMapping("/logout")
  public String signout() {
    return "redirect:/";
  }
}
