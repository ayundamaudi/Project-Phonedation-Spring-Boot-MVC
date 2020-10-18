package com.bca.controllers.admin;

import javax.validation.Valid;

import com.bca.dto.CheckoutForm;
import com.bca.dto.ErrorMessage;
import com.bca.dto.OrderForm;
import com.bca.entities.Order;
import com.bca.services.OrderDetailService;
import com.bca.services.OrderService;

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
  private OrderDetailService orderDetailService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("orders", orderService.findAll());
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
  public String edit(@PathVariable("id") String id, Model model) {
    OrderForm form = new OrderForm();
    Order order = orderService.findById(id).get();

    form.setId(order.getId());
    // form.setCheckoutDate(order.getCheckoutDate());
    // form.setCreatedOrder(order.getCreatedOrder());
    // form.setCreatedPayment(order.getCreatedPayment());
    // form.setReceiptNumber(order.getReceiptNumber());
    // form.setService(order.getService());
    // form.setShippingFee(order.getShippingFee());
    // form.setSubTotal(order.getSubTotal());
    // form.setTotalPrice(order.getTotalPrice());
    // form.setAddressId(order.getAddress().getId());
    // form.setPaymentMethodId(order.getPaymentMethod().getId());
    // form.setUserId(order.getUser().getId());

    form.setStatus(form.getStatus());

    model.addAttribute("form", form);
    model.addAttribute("order", order);
    model.addAttribute("details", orderDetailService.findAllByOrder(order));
    return BASE_PATH.concat("/detail");
  }

  // Logger log = LoggerFactory.getLogger(this.getClass());
  // @GetMapping("/edit/{id}")
  // public String edit(@PathVariable("id") String id, Model model) {
  // Order order = orderService.findById(id).get();
  // log.info(order.toString());
  // model.addAttribute("order", order);
  // Iterable<OrderDetail> orderDetails =
  // orderDetailService.findAllByOrder(order);
  // log.info(orderDetails.toString());
  // model.addAttribute("details", orderDetails);
  // return BASE_PATH.concat("/detail");
  // }

  @PostMapping("/update")
  public String update(OrderForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Order data = orderService.findById(form.getId()).get();

      data.setStatus(form.getStatus());

      orderService.save(data);
      return "redirect:".concat(BASE_PATH);

    } else {
      ErrorMessage errorMessage = new ErrorMessage();
      for (ObjectError err : bindingResult.getAllErrors()) {
        errorMessage.getMessages().add(err.getDefaultMessage());
      }
      model.addAttribute("form", form);
      model.addAttribute("errors", errorMessage);
      return BASE_PATH.concat("/edit");
    }
  }

  @PostMapping("/remove/{id}")
  public String delete(@PathVariable("id") String id) {
    orderService.deleteById(id);
    return "redirect:".concat(BASE_PATH);
  }
}
