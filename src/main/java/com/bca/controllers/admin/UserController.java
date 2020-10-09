package com.bca.controllers.admin;

import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.UserForm;
import com.bca.entities.User;
import com.bca.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/user")
public class UserController {
  private String BASE_PATH = "/admin/user";

  @Autowired
  private UserService userService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("users", userService.findAll());
    return BASE_PATH.concat("/index");
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("form", new UserForm());
    return BASE_PATH.concat("/create");
  }

  @PostMapping("/insert")
  public String insert(@Valid UserForm form, Model model, BindingResult bindingResult,
		  RedirectAttributes redirectAttribute) {
    if (!bindingResult.hasErrors()) {
      User data = new User();

      data.setEmail(form.getEmail());
      data.setPassword(form.getPassword());
      data.setFullname(form.getFullname());
      data.setPhoto(form.getPhoto());
      data.setRole(form.getRole());

      userService.save(data);
      return "redirect:".concat(BASE_PATH);

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
      return BASE_PATH.concat("/create");
    }
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") int id, Model model) {
    UserForm form = new UserForm();
    User data = userService.findById(id).get(); // FIXME: Use Optional Class

    form.setId(data.getId());
    form.setEmail(data.getEmail());
    form.setPassword(data.getPassword());
    form.setFullname(data.getFullname());
    form.setPhoto(data.getPhoto());

    model.addAttribute("form", form);
    return BASE_PATH.concat("/edit");
  }

  @PostMapping("/update")
  public String update(@Valid UserForm form, Model model, BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      User data = userService.findById(form.getId()).get();

      data.setId(form.getId());
      data.setEmail(form.getEmail());
      data.setPassword(form.getPassword());
      data.setFullname(form.getFullname());
      data.setPhoto(form.getPhoto());

      userService.save(data);
      return "redirect:".concat(BASE_PATH);

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
      return BASE_PATH.concat("/edit");
    }
  }

  @GetMapping("/remove/{id}")
  public String delete(@PathVariable("id") int id) {
    userService.deleteById(id);
    return "redirect:".concat(BASE_PATH);
  }
}