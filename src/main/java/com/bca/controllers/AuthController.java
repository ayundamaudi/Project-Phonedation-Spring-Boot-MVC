package com.bca.controllers;

import javax.servlet.http.HttpSession;
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
  private HttpSession session;

  @Autowired
  private AuthService authService;

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("user", new UserForm());
    return "login";
  }

  @PostMapping("/signin")
  public String signin(UserForm form, Model model) throws Exception {
    User user = authService.signin(form.getEmail(), form.getPassword());
    if (user != null) {
      session.setAttribute("USER", user);
      if (user.getRole().equals("admin")) {
        return "redirect:/admin/dashboard";
      } else {
        return "redirect:/";
      }
    } else {
      model.addAttribute("user", form);
      return "redirect:/login";
    }
  }

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("form", new UserForm());
    return "register";
  }

  @PostMapping("/signup")
  public String signup(@Valid UserForm form, BindingResult bindingResult, Model model) throws Exception {
    if (!bindingResult.hasErrors()) {
      User data = new User();

      data.setEmail(form.getEmail());
      data.setPassword(form.getPassword()); // FIXME: Add hash
      data.setFullname(form.getFullname());
      data.setPhoto("no photo");
      data.setRole("user");

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

  @GetMapping("/signout") // TODO: is it better to use GET or POST?
  public String signout() {
    session.removeAttribute("USER");
    return "redirect:/login";
  }
}
