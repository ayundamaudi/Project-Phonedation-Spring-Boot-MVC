package com.bca.controllers;

import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.UserForm;
import com.bca.entities.User;
import com.bca.services.AuthService;
import com.bca.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

  @Autowired
  private AuthService authService;

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/signin")
  public String signin(UserForm form) throws Exception {
    if (authService.signin(form.getEmail(), form.getPassword()) != null) {
      return "redirect:/admin/dashboard";
    } else {
      return "login";
    }
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @PostMapping("/signup")
  public String signup(@Valid UserForm form, BindingResult bindingResult, Model model) throws Exception {
    if (!bindingResult.hasErrors()) {
      User data = new User();

      data.setEmail(form.getEmail());
      data.setPassword(form.getPassword());
      data.setFullname(form.getFullname());
      data.setPhoto(form.getPhoto());
      data.setRole(form.getRole());

      userService.save(data);
      return "redirect:/login";

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
      return "register";
    }
  }

  @PostMapping("/signout")
  public String signout() {
    return "redirect:/login";
  }
}
