package com.bca.controllers;

import com.bca.RajaOngkirAPI;
import com.bca.dto.CheckoutForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping
public class CheckoutController {
  Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/checkout")
  public String index(Model model) {
    model.addAttribute("cities", RajaOngkirAPI.findAllCity().getBody().getResults());
    model.addAttribute("provinces", RajaOngkirAPI.findAllProvince().getBody().getResults());

    model.addAttribute("form", new CheckoutForm());
    return "customer/checkout";
  }

}
