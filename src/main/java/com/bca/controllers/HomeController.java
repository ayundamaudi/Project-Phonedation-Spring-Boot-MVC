package com.bca.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {

  @Autowired
  private HttpSession session;

  @GetMapping
  public String home() {
    if (session.getAttribute("USER") == null) {
      return "redirect:/login";

    }
    return "home";

  }
}
