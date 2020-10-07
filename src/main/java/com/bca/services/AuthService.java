package com.bca.services;

import com.bca.entities.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
  // @Autowired
  // private UserRepo repo;

  public User signup(User user) {
    return null;
  }

  public User signin(String email, String password) {
    return null;
  }

  public void signout() {

  }
}
