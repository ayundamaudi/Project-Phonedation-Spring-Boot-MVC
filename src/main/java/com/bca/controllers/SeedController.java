package com.bca.controllers;

import com.bca.entities.User;
import com.bca.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SeedController {
  @Autowired
  private UserService userService;

  @GetMapping("/seed")
  public String seed() {
    /*
     * Brand brand = new Brand(); brand.setBrand("Apple");
     * 
     * brandService.save(brand);
     * 
     * Product product = new Product(brand, "iPhone 7 Plus", "128 GB", "3 GB RAM",
     * "Black",
     * "SIM : Nano-SIM; Dimensi: 158.2 x 77.9 x 7.3 mm (6.23 x 3.07 x 0.29 in); Display Type: LED-backlit IPS LCD  capacitive touchscreen  16M colors; Display Resolution: 5.5 inches (~67.7% screen-to-body ratio); Display Size: 1080 x 1920 pixels (~401 ppi pixel density); OS: iOS 10.0.1| upgradable to iOS 10.3.2; CPU: Quad-core 2.34 GHz (2x Hurricane + 2x Zephyr); Chipset: Apple A10 Fusion; GPU: PowerVR Series7XT Plus (six-core graphics); Primary Camera: Dual 12 MP| (28mm| f/1.8| OIS & 56mm| f/2.8)| phase detection autofocus| 2x optical zoom| quad-LED (dual tone) flash| ; Second Camera: 7 MP| f/2.2| 32mm| 1080p@30fps| 720p@240fps| face detection| HDR| panorama; Sensor: Fingerprint (front-mounted)| accelerometer| gyro| proximity| compass| barometer; Battery: Non-removable Li-Ion 2900 mAh battery (11.1 Wh)"
     * , 188, 20, 900, 1, "iPhone_7_Plus_BLACK.jpg", new Date(), null);
     * 
     * productService.save(product);
     */

    User user = new User();
    user.setEmail("admin@domain.com");
    user.setFullname("admin");
    user.setPassword("admin");
    user.setPhoto("admin.jpg");
    user.setRole("admin");
    userService.save(user);
    return "redirect:/";
  }
}
