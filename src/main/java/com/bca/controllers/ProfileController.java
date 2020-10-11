package com.bca.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.UserForm;
import com.bca.entities.User;
import com.bca.services.AddressService;
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
public class ProfileController {

  @Autowired
  private HttpSession session;

  @Autowired
  private UserService userService;

  @Autowired
  private AddressService addressService;

  @GetMapping("/profile")
  public String index(Model model) {
    model.addAttribute("user", userService.findById(1)); // FIXME: get user_id by session
    return "/customer/profile/index";
  }

  @PostMapping("/profile/update")
  public String update(@Valid UserForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      User data = userService.findById(form.getId()).get();

      data.setId(form.getId());
      data.setEmail(form.getEmail());
      data.setPassword(form.getPassword());
      data.setFullname(form.getFullname());
      data.setPhoto(form.getPhoto());

      userService.save(data);
    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }

      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
    }
    return "redirect:/profile";
  }

}
