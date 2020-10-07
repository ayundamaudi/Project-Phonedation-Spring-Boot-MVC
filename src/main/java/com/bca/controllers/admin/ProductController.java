package com.bca.controllers.admin;

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

import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.ProductForm;
import com.bca.entities.Product;
import com.bca.repositories.BrandRepo;
import com.bca.repositories.ProductRepo;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
  private String BASE_PATH = "/admin/product";

  @Autowired
  private ProductRepo productRepo;

  @Autowired
  private BrandRepo brandRepo;

  @GetMapping("/index")
  public String index(Model model) {
    // return
    return BASE_PATH.concat("/index");
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("BRANDS", brandRepo.findAll());
    return BASE_PATH.concat("/form");
  }

  @PostMapping("/create")
  public String insert(@Valid ProductForm form, Model model, BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      Product data = new Product();

      data.setModel(form.getModel());
      data.setInternalMemory(form.getInternalMemory());
      data.setRam(form.getRam());
      data.setColor(form.getColor());
      data.setDescription(form.getDescription());
      data.setStock(form.getStock());
      data.setSold(form.getSold());
      data.setPrice(form.getPrice());
      data.setWeight(form.getWeight());
      data.setBrand(brandRepo.findById(form.getBrandId()).get());

      productRepo.save(data);
      return "redirect:".concat(BASE_PATH).concat("/index");

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("PRODUCTS", form);
      model.addAttribute("BRANDS", brandRepo.findAll());
      model.addAttribute("ERRORS", errorMessage);
      return BASE_PATH.concat("/form");
    }
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") int id, Model model, ProductForm form) {
    Product data = productRepo.findById(id).get();
    if (data != null) {
      model.addAttribute("data", form);
    }

    return BASE_PATH.concat("/form");
  }

  @PutMapping("/update")
  public String update(@PathVariable("id") int id, @Valid ProductForm form, Model model, BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      Product data = productRepo.findById(id).get();

      data.setModel(form.getModel());
      data.setInternalMemory(form.getInternalMemory());
      data.setRam(form.getRam());
      data.setColor(form.getColor());
      data.setDescription(form.getDescription());
      data.setStock(form.getStock());
      data.setSold(form.getSold());
      data.setPrice(form.getPrice());
      data.setWeight(form.getWeight());
      data.setBrand(brandRepo.findById(form.getBrandId()).get());

      productRepo.save(data);
      return "redirect:".concat(BASE_PATH).concat("/index");

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("PRODUCTS", form);
      model.addAttribute("BRANDS", brandRepo.findAll());
      model.addAttribute("ERRORS", errorMessage);
      return BASE_PATH.concat("/form");
    }
  }

  @DeleteMapping("/remove/{id}")
  public String delete(@PathVariable("id") int id) {
    productRepo.deleteById(id);
    return "redirect:".concat(BASE_PATH).concat("/index");
  }
}