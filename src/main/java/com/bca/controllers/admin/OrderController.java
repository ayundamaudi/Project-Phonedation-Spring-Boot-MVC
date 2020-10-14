package com.bca.controllers.admin;

import javax.validation.Valid;

import com.bca.dto.CheckoutForm;
import com.bca.dto.ErrorMessage;
import com.bca.entities.Order;
import com.bca.services.AddressService;
import com.bca.services.OrderService;
import com.bca.services.PaymentMethodService;
import com.bca.repositories.OrderDetailRepo;
import com.bca.entities.OrderDetail;

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
@RequestMapping("/admin/order")
public class OrderController {
  private String BASE_PATH = "/admin/order";

  @Autowired
  private OrderService orderService;

  @Autowired
  private OrderDetailRepo orderDetailRepo;

  @Autowired
  private AddressService addressService;

  @Autowired
  private PaymentMethodService paymentService;

  @GetMapping
  public String index(Model model) {
    Iterable<OrderDetail> details = orderDetailRepo.findAll();
    model.addAttribute("details", details);
    return BASE_PATH.concat("/index");
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("form", new CheckoutForm());
    return BASE_PATH.concat("/create");
  }

  @PostMapping("/insert")
  public String insert(@Valid CheckoutForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Order data = new Order();

      // data.setAddress(addressService.findById(form.getAddress()) address);
      // data.setCourier(form.getShipments()); //FIXME: Rename to getCourier()
      // data.setPaymentMethod(paymentMethod);
      // data.setReceiptNumber(form.g);

      orderService.save(data);
      return "redirect:".concat(BASE_PATH);

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
      return BASE_PATH.concat("/create");
    }
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") long id, Model model) {
    // TODO: add get by service
    return BASE_PATH.concat("/edit");
  }

  @PostMapping("/update")
  public String update(@PathVariable("id") int id, CheckoutForm form, BindingResult bindingResult, Model model) {
    // TODO: add update service
    return "redirect:".concat(BASE_PATH);
  }

  @PostMapping("/remove/{id}")
  public String delete(@PathVariable("id") int id) {
    orderService.deleteById(id);
    return "redirect:".concat(BASE_PATH);
  }
}
