package com.bca.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpSession;

import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.entities.Product;
import com.bca.entities.User;
import com.bca.entities.Wishlist;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;
import com.bca.services.ProductService;
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
  private HttpSession session;

  @Autowired
  private ProductService productService;

  @Autowired
  private WishlistService wishlistService;

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
    model.addAttribute("product", productService.findById(id).get());
    return "customer/product/detail";
  }

  @PostMapping("product/{id}/addtocart")
  public String addToCart(@PathVariable("id") int id) {
    Order order = orderService.findById((int) session.getAttribute("CART_ID")).get();
    Product product = productService.findById(id).get();

    OrderDetail cart = orderDetailService.findByOrderAndProduct(order, product);
    if (cart == null) {
      cart = new OrderDetail();

      cart.setOrder(order);
      cart.setProduct(product);
      cart.setQuantity(1);
      cart.setPrice(product.getPrice()); // FIXME: insert DB trigger get price
    } else {
      cart.setQuantity(cart.getQuantity() + 1);
    }
    orderDetailService.save(cart);
    order.setTotalPrice(order.getTotalPrice() + product.getPrice());

    // Get total items in cart
    Iterable<OrderDetail> list = orderDetailService.findAllByOrder(order);
    List<OrderDetail> items = StreamSupport.stream(list.spliterator(), false).collect(Collectors.toList());
    session.setAttribute("items", items.size());
    return "redirect:/product/" + id;
  }

  @PostMapping("product/{id}/addtowishlist")
  public String addToWishlist(@PathVariable("id") int id) {
    Product product = productService.findById(id).get();
    Wishlist data = wishlistService.findByUserAndProduct((User) session.getAttribute("USER"), product);

    if (data == null) {
      data = new Wishlist();
      data.setUser(((User) session.getAttribute("USER")));
      data.setProduct(productService.findById(id).get());
      wishlistService.save(data);
    }

    return "redirect:/product/" + id;
  }
}
