package com.bca.controllers.admin;

import javax.validation.Valid;

import com.bca.dto.AddressForm;
import com.bca.dto.ErrorMessage;
import com.bca.entities.Address;
import com.bca.services.AddressService;
import com.bca.services.PostalCodeService;
import com.bca.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/address")
public class AddressController {
  private String BASE_PATH = "/admin/address";

  @Autowired
  private AddressService addressService;

  @Autowired
  private UserService userService;

  @Autowired
  private PostalCodeService postalCodeService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("addresses", addressService.findAll());
    return BASE_PATH.concat("/index");
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("form", new AddressForm());
    return BASE_PATH.concat("/create");
  }

  @PostMapping("/insert")
  public String insert(@Valid AddressForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Address data = new Address();

      data.setAddress(form.getAddress());
      data.setPhoneNumber(form.getPhoneNumber());
      // FIXME: PostalCode id type not consistent
      data.setPostalCode(postalCodeService.findById(Integer.parseInt(form.getPostalCodes())).get());
      data.setReceiverName(form.getReceiverName());
      data.setUser(userService.findById(form.getUserId()).get());

      addressService.save(data);
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
  public String edit(@PathVariable("id") int id, Model model) {
    model.addAttribute("form", addressService.findById(id).get().toForm());
    return BASE_PATH.concat("/edit");
  }

  @PutMapping("/update")
  public String update(@PathVariable("id") int id, AddressForm form, BindingResult bindingResult, Model model) {
    if (!bindingResult.hasErrors()) {
      Address data = addressService.findById(id).get();

      data.setAddress(form.getAddress());
      data.setPhoneNumber(form.getPhoneNumber());
      data.setPostalCode(postalCodeService.findById(Integer.parseInt(form.getPostalCodes())).get());
      data.setReceiverName(form.getReceiverName());
      data.setUser(userService.findById(form.getUserId()).get());

      addressService.save(data);
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

  @DeleteMapping("/remove/{id}")
  public String delete(@PathVariable("id") int id) {
    addressService.deleteById(id);
    return "redirect:".concat(BASE_PATH);
  }
}
