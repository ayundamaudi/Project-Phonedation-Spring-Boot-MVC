package com.bca.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.bca.MidtransAPI;
import com.bca.RajaOngkirAPI;
import com.bca.dto.CheckoutForm;
import com.bca.entities.Order;
import com.bca.entities.User;
import com.bca.models.MidtransResponse;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CheckoutController {
  Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private HttpSession session;

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderDetailService orderDetailService;

  @GetMapping("/checkout")
  public String index(Model model) {
    model.addAttribute("cities", RajaOngkirAPI.findAllCity().getBody().getResults());
    model.addAttribute("provinces", RajaOngkirAPI.findAllProvince().getBody().getResults());

    model.addAttribute("form", new CheckoutForm());
    return "customer/checkout";
  }

  // semangat herdhiiii
  // SEMANGAAAATTT HERDHIIII !!!!
  // wkwkkwkwk
  // string wkwkwkk biarin ajaa
  // 👍👌🙂 wkwkwkwk
  // 🔥🔥 🔥🔥 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
  // 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
  // gimana bikin emot api biar semangat?
  // WAH BISA GAAESS!!!!!!
  // https://app.sandbox.midtrans.com/snap/v2/vtweb/cc6fe755-0f56-4b5c-9701-8febe5bec470
  // 👈 buka
  // otw 🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
  // tidak menemukan transaksi :(
  // Kurang 1 huruf 😟
  // bisa nihhh, gimana caranya kirim gambar disini?
  // <img src = "/img/midtrans.jpg>"
  // pake JNE, apanya ?
  // tampilannya berantakan tapi
  // Bagus kok
  // AKu buka di Microsoft Edge juga begitu tadi, tapi waktu dibuka pake Chrome
  // jadi bagus
  // aku buka di chrome, berantakan:(
  // yang penting ada yg bagus :)
  // di edge aku, bagussss

  @PostMapping("/pay")
  public String wkwk() {
    Order order = orderService.findById((int) session.getAttribute("CART_ID")).get();
    ResponseEntity<String> response = MidtransAPI.snap(order.getId(), (int) order.getTotalPrice());
    log.info(order.toString());
    String redirectUrl = null;
    try {
      MidtransResponse body = new ObjectMapper().readValue(response.getBody(), MidtransResponse.class);
      redirectUrl = body.getRedirectUrl();
      log.info(body.toString());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    log.info(response.getBody());
    return "redirect:" + redirectUrl;
  }

  @GetMapping("/payment")
  public String payment(Model model) {
    Order order = orderService.findById((int) session.getAttribute("CART_ID")).get();
    model.addAttribute("order", order);
    model.addAttribute("orderdetails", orderDetailService.findAllByOrder(order));
    return "customer/payment";
  }

  @PostMapping("/paymentsuccess")
  public String paymentSuccess(Model model) {
    Order currentOrder = orderService.findById((int) session.getAttribute("CART_ID")).get();
    currentOrder.setCheckoutDate(new Date());
    currentOrder.setStatus("payment success");
    orderService.save(currentOrder);

    int orderId = (int) Math.random() * 999999;
    Order order = new Order();
    order.setId(orderId);
    order.setUser((User) session.getAttribute("USER"));
    order.setStatus("Shopping");
    orderService.save(order);

    session.setAttribute("CART_ID", order.getId());

    return "redirect:/";
  }

}
