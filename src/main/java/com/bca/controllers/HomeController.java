package com.bca.controllers;

import com.bca.dto.SearchForm;
import com.bca.services.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {
  @Autowired
  private ProductService productService;

  Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping
  public String home(Model model) {
    model.addAttribute("products", productService.findAll());
    model.addAttribute("latest", productService.findLatestProducts());
    model.addAttribute("bestseller", productService.findBestsellerProducts());
    model.addAttribute("form", new SearchForm());

    return "home";
  }

  @GetMapping("/search")
  public String home(SearchForm form, Model model) {
    model.addAttribute("products", productService.searchByModel(form.getKeyword()));
    model.addAttribute("latest", productService.findLatestProducts());
    model.addAttribute("bestseller", productService.findBestsellerProducts());
    model.addAttribute("form", form);
    return "home";
  }
}
