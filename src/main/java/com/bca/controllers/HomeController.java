package com.bca.controllers;

import javax.servlet.http.HttpSession;

import com.bca.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {

  @Autowired
  private HttpSession session;

  @Autowired
  private ProductService productService;

  @GetMapping
  public String home(Model model) {
    if (session.getAttribute("USER") == null) {
      return "redirect:/login";

    }
    model.addAttribute("products", productService.findAll());
    return "home";

  }
}
