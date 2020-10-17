package com.bca.controllers;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.bca.MidtransAPI;
import com.bca.RajaOngkirAPI;
import com.bca.dto.CheckoutForm;
import com.bca.entities.Address;
import com.bca.entities.Order;
import com.bca.entities.User;
import com.bca.models.MidtransResponse;
import com.bca.models.RajaOngkirCityResponse;
import com.bca.models.RajaOngkirProvinceResponse;
import com.bca.models.city.Result;
import com.bca.services.AddressService;
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

  @Autowired
  private AddressService addressService;

  @GetMapping("/checkout")
  public String index(Model model) {
    RajaOngkirProvinceResponse provinces = RajaOngkirAPI.findAllProvince().getBody();
    RajaOngkirCityResponse cities = RajaOngkirAPI.findAllCity().getBody();

    for (Result c : cities.getRajaongkir().getResults()) {
      log.info(c.toString());
    }
    model.addAttribute("provinces", provinces.getRajaongkir().getResults());
    model.addAttribute("cities", cities.getRajaongkir().getResults());

    model.addAttribute("form", new CheckoutForm());
    return "customer/checkout";
  }

  @PostMapping("/checkout")
  public String checkout(CheckoutForm form) {
    Address address = new Address();
    address.setAddress(form.getAddress());
    address.setReceiverName(form.getReceiver());
    address.setPhoneNumber(form.getPhone());
    address.setPostalCode(addressService.findPostalCodeById(form.getPostalcode()));
    address.setUser((User) session.getAttribute("USER"));

    session.setAttribute("ADDRESS", address);
    return "redirect:/payment";
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
    Order order = orderService.findById((String) session.getAttribute("CART_ID")).get();
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
    if (((Address) session.getAttribute("ADDRESS")) == null) {
      return "redirect:/checkout";
    }
    Order order = orderService.findById((String) session.getAttribute("CART_ID")).get();
    model.addAttribute("order", order);
    model.addAttribute("orderdetails", orderDetailService.findAllByOrder(order));
    return "customer/payment";
  }

  @PostMapping("/payment/success")
  public String paymentSuccess() {
    Order currentOrder = orderService.findById((String) session.getAttribute("CART_ID")).get();
    currentOrder.setCheckoutDate(new Date());
    currentOrder.setAddress((Address) session.getAttribute("ADDRESS"));
    currentOrder.setStatus("payment success");
    orderService.save(currentOrder);

    UUID orderId = UUID.randomUUID();
    Order order = new Order();
    order.setId(orderId.toString());
    order.setUser((User) session.getAttribute("USER"));
    order.setStatus("Shopping");
    orderService.save(order);

    session.setAttribute("CART_ID", order.getId());
    session.removeAttribute("ADDRESS");

    return "redirect:/";
  }

}
