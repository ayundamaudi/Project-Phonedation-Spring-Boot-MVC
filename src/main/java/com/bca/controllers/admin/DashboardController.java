package com.bca.controllers.admin;

import com.bca.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/dashboard")
  public String dashboard(Model model) {
    model.addAttribute("orders", orderService.findCheckoutOrder());
    return "admin/dashboard";
  }
}
