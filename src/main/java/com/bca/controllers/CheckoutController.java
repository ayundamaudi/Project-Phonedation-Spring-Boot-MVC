package com.bca.controllers;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bca.MidtransAPI;
import com.bca.RajaOngkirAPI;
import com.bca.dto.CheckoutForm;
import com.bca.dto.ErrorMessage;
import com.bca.entities.Address;
import com.bca.entities.Order;
import com.bca.entities.User;
import com.bca.models.MidtransResponse;
import com.bca.models.RajaOngkirCityResponse;
import com.bca.models.RajaOngkirProvinceResponse;
import com.bca.models.cost.ItemCost;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    model.addAttribute("provinces", provinces.getRajaongkir().getResults());
    model.addAttribute("cities", cities.getRajaongkir().getResults());
    model.addAttribute("form", new CheckoutForm());

    return "customer/checkout";
  }

  @PostMapping("/checkout")
  public String checkout(@Valid CheckoutForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Order order = orderService.findById((String) session.getAttribute("CART_ID")).get();

      Address address = new Address();
      address.setAddress(form.getAddress());
      address.setReceiverName(form.getReceiver());
      address.setPhoneNumber(form.getPhone());
      address.setPostalCode(addressService.findPostalCodeById(form.getPostalcode()));
      address.setUser((User) session.getAttribute("USER"));
      addressService.save(address);

      String JAKARTA_ID = "151";
      ResponseEntity<String> response = RajaOngkirAPI.cost(JAKARTA_ID, form.getCity(), 1700.0, form.getCourier());
      ItemCost body = null;
      try {
        body = new ObjectMapper().readValue(response.getBody(), ItemCost.class);
        log.info(body.toString());
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      order.setAddress(address);
      order.setCourier(form.getCourier());
      order.setService(body.getRajaongkir().getResults().get(0).getCosts().get(0).getService());
      order.setShippingFee(body.getRajaongkir().getResults().get(0).getCosts().get(0).getCost().get(0).getValue());
      order.setTotalPrice(order.getTotalPrice() + order.getShippingFee());
      orderService.save(order);

      session.setAttribute("ADDRESS", address);
      session.setAttribute("SHIPMENT", body);
      return "redirect:/payment";
    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
      return "customer/checkout";
    }
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
    Order currentOrder = orderService.findById((String) session.getAttribute("CART_ID")).get();
    currentOrder.setAddress((Address) session.getAttribute("ADDRESS"));
    currentOrder.setCheckoutDate(new Date());
    currentOrder.setStatus("Waiting for Payment");
    orderService.save(currentOrder);

    ResponseEntity<String> response = MidtransAPI.snap(currentOrder.getId(), (int) currentOrder.getTotalPrice());
    log.info(currentOrder.toString());
    String redirectUrl = null;
    try {
      MidtransResponse body = new ObjectMapper().readValue(response.getBody(), MidtransResponse.class);
      redirectUrl = body.getRedirectUrl();

      UUID orderId = UUID.randomUUID();
      Order order = new Order();
      order.setId(orderId.toString());
      order.setUser((User) session.getAttribute("USER"));
      order.setStatus("Shopping");
      orderService.save(order);

      session.setAttribute("CART_ID", order.getId());
      session.removeAttribute("ADDRESS");

      return "redirect:" + redirectUrl;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      return "redirect:/payment";
    }
  }

  @GetMapping("/payment")
  public String payment(Model model) {
    // Address address = (Address) session.getAttribute("ADDRESS");
    // if (address == null) {
    // return "redirect:/checkout";
    // }
    Order order = orderService.findById((String) session.getAttribute("CART_ID")).get();
    model.addAttribute("order", order);
    model.addAttribute("orderdetails", orderDetailService.findAllByOrder(order));
    return "customer/payment";
  }

  @GetMapping("/payment/success")
  public String paymentSuccess() {
    // Order currentOrder = orderService.findById((String)
    // session.getAttribute("")).get();
    // currentOrder.setCreatedPayment(new Date());
    // currentOrder.setStatus("payment success");
    // orderService.save(currentOrder);

    return "redirect:/";
  }

}
