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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.ProductForm;
import com.bca.entities.Product;
import com.bca.repositories.BrandRepo;
import com.bca.repositories.ProductRepo;
import com.bca.services.BrandService;
import com.bca.services.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
  private String BASE_PATH = "/admin/product";

  @Autowired
  private ProductService productService;

  @Autowired
  private BrandService brandService;

  @Autowired
  private ProductRepo productRepo;

  @Autowired
  private BrandRepo brandRepo;

  @GetMapping
  public String index(Model model) {
    Iterable<Product> products = productRepo.findAll();
    model.addAttribute("products", products);
    return BASE_PATH.concat("/index");
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("brands", brandService.findAll());
    model.addAttribute("form", new ProductForm());
    return BASE_PATH.concat("/create");
  }

  @PostMapping("/insert")
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
      data.setImage(form.getImage());
      data.setBrand(brandService.findById(form.getBrandId()).get());

      productService.save(data);
      return "redirect:".concat(BASE_PATH);

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("PRODUCTS", form);
      model.addAttribute("BRANDS", brandService.findAll());
      model.addAttribute("ERRORS", errorMessage);
      return BASE_PATH.concat("/create");
    }
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") int id, Model model) {
    Product data = productService.findById(id).get();
    model.addAttribute("brands", brandService.findAll());
    ProductForm form = new ProductForm();
    form.setId(data.getId());
    form.setModel(data.getModel());
    form.setInternalMemory(data.getInternalMemory());
    form.setRam(data.getRam());
    form.setColor(data.getColor());
    form.setDescription(data.getDescription());
    form.setStock(data.getStock());
    form.setSold(data.getSold());
    form.setPrice(data.getPrice());
    form.setWeight(data.getWeight());
    form.setBrandId(data.getBrand().getId());
    model.addAttribute("form", form);
    return BASE_PATH.concat("/edit");
  }

  @PostMapping("/update")
  public String update(@Valid ProductForm form, Model model, BindingResult bindingResult,
      RedirectAttributes redirectAttribute) {
    if (!bindingResult.hasErrors()) {
      Product data = productService.findById(form.getId()).get();

      data.setId(form.getId());
      data.setModel(form.getModel());
      data.setInternalMemory(form.getInternalMemory());
      data.setRam(form.getRam());
      data.setColor(form.getColor());
      data.setDescription(form.getDescription());
      data.setStock(form.getStock());
      data.setSold(form.getSold());
      data.setPrice(form.getPrice());
      data.setWeight(form.getWeight());
      data.setBrand(brandService.findById(form.getBrandId()).get());

      productService.save(data);
      return "redirect:".concat(BASE_PATH);

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("PRODUCTS", form);
      model.addAttribute("BRANDS", brandRepo.findAll());
      model.addAttribute("ERRORS", errorMessage);
      return BASE_PATH.concat("/create");
    }
  }

  @GetMapping("/remove/{id}")
  public String delete(@PathVariable("id") int id) {
    productService.delete(id);
    return "redirect:".concat(BASE_PATH);
  }
}