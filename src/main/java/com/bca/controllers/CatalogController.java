package com.bca.controllers;

import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.entities.Wishlist;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;
import com.bca.services.ProductService;
import com.bca.services.UserService;
import com.bca.services.WishlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CatalogController {

  @Autowired
  private ProductService productService;

  @Autowired
  private WishlistService wishlistService;

  @Autowired
  private UserService userService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderDetailService orderDetailService;

  @GetMapping("/product")
  public String index(Model model) {
    model.addAttribute("products", productService.findAll());
    return "/customer/product/catalog";
  }

  @GetMapping("/product/{id}")
  public String detail(@PathVariable("id") int id, Model model) {
    model.addAttribute("product", productService.findById(id));
    return "/customer/product/detail";
  }

  @PostMapping("product/{id}/addtocart")
  public String addToCart(@PathVariable("id") int id) {
    OrderDetail cart = new OrderDetail();

    // FIXME: get order_id by session.. is it good to save order_id by session?
    cart.setOrder(orderService.findById(1).get());
    cart.setProduct(productService.findById(id).get());
    cart.setQuantity(1); // FIXME: add addToCart Form?
    cart.setPrice(productService.findById(id).get().getPrice()); // FIXME: insert DB trigger get price

    orderDetailService.save(cart);
    return "redirect:/product/" + id;
  }

  @PostMapping("product/{id}/addtowishlist")
  public String addToWishlist(@PathVariable("id") int id) {
    Wishlist data = new Wishlist();

    data.setUser(userService.findById(1).get()); // FIXME: get user_id by session
    data.setProduct(productService.findById(id).get());
    wishlistService.save(data);

    return "redirect:/product/" + id;
  }
}