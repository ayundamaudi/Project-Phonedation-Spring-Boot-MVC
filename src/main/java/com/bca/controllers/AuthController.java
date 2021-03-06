package com.bca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.UserForm;
import com.bca.entities.Ewallet;
import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.entities.Product;
import com.bca.entities.User;
import com.bca.services.AuthService;
import com.bca.services.EwalletService;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;
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

  @Autowired
  private EwalletService ewalletService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderDetailService orderDetailService;

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
      for (Order order : orderService.findByUser(user)) {
        if (order.getCheckoutDate() == null) {
          session.setAttribute("CART_ID", order.getId());
          session.setAttribute("CART", new ArrayList<Product>());

          Iterable<OrderDetail> list = orderDetailService.findAllByOrder(order);
          List<OrderDetail> items = StreamSupport.stream(list.spliterator(), false).collect(Collectors.toList());
          session.setAttribute("items", items.size());
        }
      }

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
      data.setPassword(form.getPassword());
      data.setFullname(form.getFullname());
      data.setPhoto("no photo");
      data.setRole("user");

      userService.save(data);

      UUID orderId = UUID.randomUUID();
      Order order = new Order();
      order.setId(orderId.toString());
      order.setUser(data);
      order.setStatus("Shopping");
      orderService.save(order);

      Ewallet ewallet = new Ewallet();
      ewallet.setBalance(0);
      ewallet.setPin(123456); // FIXME: Change static value
      ewallet.setUser(data);
      ewalletService.save(ewallet);

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

  @GetMapping("/signout")
  public String signout() {
    session.removeAttribute("USER");
    return "redirect:/login";
  }
}
