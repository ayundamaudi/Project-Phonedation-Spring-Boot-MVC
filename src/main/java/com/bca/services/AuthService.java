package com.bca.services;

import com.bca.entities.User;
import com.bca.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
  @Autowired
  private UserRepo repo;

  public void signup(User user) throws Exception {
    // user.setPassword(MD5Generator.encode(user.getPassword()));
    repo.save(user);
  }

  public User signin(String email, String password) throws Exception {
    return repo.findByEmailAndPassword(email, password);
    // return repo.findByEmailAndPassword(email, MD5Generator.encode(password)); //
    // FIXME: Add hash
  }
}
