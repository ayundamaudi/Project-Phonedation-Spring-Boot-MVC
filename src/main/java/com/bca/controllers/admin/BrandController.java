package com.bca.controllers.admin;

import javax.validation.Valid;

import com.bca.dto.BrandForm;
import com.bca.dto.ErrorMessage;
import com.bca.entities.Brand;
import com.bca.services.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {
  private String BASE_PATH = "/admin/brand";

  @Autowired
  private BrandService mainService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("data", mainService.findAll());
    return BASE_PATH.concat("/index");
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("form", new BrandForm());
    return BASE_PATH.concat("/create");
  }

  @PostMapping("/insert")
  public String insert(@Valid BrandForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Brand data = new Brand();

      data.setBrand(form.getBrand());

      mainService.save(data);
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
    model.addAttribute("form", mainService.findById(id).get().toForm());
    return BASE_PATH.concat("/edit");
  }

  @PutMapping("/update")
  public String update(@PathVariable("id") int id, @Valid BrandForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Brand data = mainService.findById(id).get();

      data.setBrand(form.getBrand());

      mainService.save(data);
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

  @DeleteMapping("/remove/{id}")
  public String delete(@PathVariable("id") int id) {
    mainService.deleteById(id);
    return "redirect:".concat(BASE_PATH);
  }
}
