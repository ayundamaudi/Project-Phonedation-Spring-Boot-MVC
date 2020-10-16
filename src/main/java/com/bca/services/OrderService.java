package com.bca.services;

import java.util.Optional;

import com.bca.entities.Order;
import com.bca.entities.User;
import com.bca.repositories.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

  @Autowired
  private OrderRepo orderRepo;

  public Iterable<Order> findAll() {
    return orderRepo.findAll();
  }

  public Iterable<Order> findCheckoutOrderByUser(User user) {
    return orderRepo.findAllByUserAndCheckoutDateIsNotNull(user);
  }

  public Iterable<Order> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return orderRepo.findAll(pageable).getContent();
  }

  public Iterable<Order> findByUser(User user) {
    return orderRepo.findByUser(user);
  }

  public Optional<Order> findById(int id) {
    return orderRepo.findById(id);
  }

  public boolean deleteById(int id) {
    orderRepo.deleteById(id);
    return true;
  }

  public Order save(Order data) {
    return orderRepo.save(data);
  }
}
