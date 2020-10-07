package com.bca.services;

import java.util.Optional;

import com.bca.entities.User;
import com.bca.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepo userRepo;

  public Iterable<User> findAll() {
    return userRepo.findAll();
  }

  public Iterable<User> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userRepo.findAll(pageable).getContent();
  }

  public Optional<User> findById(int id) {
    return userRepo.findById(id);
  }

  public boolean deleteById(int id) {
    userRepo.deleteById(id);
    return true;
  }

  public User save(User data) {
    return userRepo.save(data);
  }
}
