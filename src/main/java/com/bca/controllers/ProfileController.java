package com.bca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bca.dto.AddressForm;
import com.bca.dto.ErrorMessage;
import com.bca.dto.ProductForm;
import com.bca.dto.UserForm;
import com.bca.entities.Address;
import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.entities.Product;
import com.bca.entities.User;
import com.bca.entities.Wishlist;
import com.bca.repositories.AddressRepo;
import com.bca.services.AddressService;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;
import com.bca.services.UserService;
import com.bca.services.WishlistService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private HttpSession session;

  @Autowired
  private UserService userService;

  @Autowired
  private AddressService addressService;

  @Autowired
  private AddressRepo addressRepo;

  @Autowired
  private WishlistService wishlistService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderDetailService orderDetailService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("form", (User) session.getAttribute("USER"));
    return "/customer/profile/index";
  }

  @PostMapping("/update")
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

  @GetMapping("/wishlist")
  public String wishlist(Model model) {
    User user = (User) session.getAttribute("USER");
    // productService.findWishlistedProductsByUser(user));
    Iterable<Wishlist> wishlists = wishlistService.findAllByUser(user);
    List<Product> products = new ArrayList<Product>();
    for (Wishlist wishlist : wishlists) {
      log.info(wishlist.getProduct().getModel());
      products.add(wishlist.getProduct());
    }
    model.addAttribute("wishlists", products);

    return "customer/profile/wishlist";
  }

  @GetMapping("/cart")
  public String cart(Model model) {
    Order order = orderService.findById((String) session.getAttribute("CART_ID")).get();
    Iterable<OrderDetail> carts = orderDetailService.findAllByOrder(order);
    model.addAttribute("carts", carts);
    return "customer/profile/cart";
  }

  @GetMapping("/order")
  public String order(Model model) {
    User user = (User) session.getAttribute("USER");
    Iterable<Order> orders = orderService.findCheckoutOrderByUser(user);
    model.addAttribute("orders", orders);
    return "customer/profile/order/index";
  }

  @GetMapping("/detail/{id}")
  public String orderDetail(@PathVariable("id") String id, Model model) {
    Order order = orderService.findById(id).get();
    log.info(order.toString());
    model.addAttribute("order", order);
    Iterable<OrderDetail> orderDetails = orderDetailService.findAllByOrder(order);
    log.info(orderDetails.toString());
    model.addAttribute("details", orderDetails);
    return "customer/profile/order/detail";
  }

  @GetMapping("/address")
  public String address(Model model) {
    Iterable<Address> address = addressRepo.findAll();
    model.addAttribute("address", address);
    return "customer/profile/address/index";
  }

  @GetMapping("/address/create")
  public String create(Model model) {
    model.addAttribute("form", new ProductForm());
    return "customer/profile/address/create";
  }

  @PostMapping("/insert")
  public String insert(@Valid AddressForm form, Model model, BindingResult bindingResult) {
    Address data = new Address();

    data.setAddress(form.getAddress());
    data.setPhoneNumber(form.getPhoneNumber());
    data.setReceiverName(form.getReceiverName());

    addressService.save(data);
    return "redirect:/address";
  }

  @GetMapping("/address/edit")
  public String editAddress() {
    return "customer/profile/address/edit";
  }

  @GetMapping("/ewallet")
  public String ewallet() {
    return "customer/profile/ewallet";
  }
}
