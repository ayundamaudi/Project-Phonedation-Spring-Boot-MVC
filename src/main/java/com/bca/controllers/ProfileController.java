package com.bca.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bca.dto.ErrorMessage;
import com.bca.dto.UserForm;
import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.entities.Product;
import com.bca.entities.User;
import com.bca.entities.Wishlist;
import com.bca.services.AddressService;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;
import com.bca.services.ProductService;
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
  private ProductService productService;

  @Autowired
  private WishlistService wishlistService;

  @Autowired
  private AddressService addressService;

  @Autowired
  private OrderService orderService; // FIXME: should this be deleted?

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
    Order order = orderService.findById((int) session.getAttribute("CART_ID")).get();
    Iterable<OrderDetail> carts = orderDetailService.findAllByOrder(order);
    // List<Product> products = new ArrayList<Product>();
    // for (OrderDetail item : carts) {
    // log.info(item.getProduct().getModel());
    // products.add(item.getProduct());
    // }
    model.addAttribute("carts", carts);
    return "customer/profile/cart";
  }

}
