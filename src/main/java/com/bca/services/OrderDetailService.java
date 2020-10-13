package com.bca.services;

import java.util.Optional;

import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.repositories.OrderDetailRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailService {

  @Autowired
  private OrderDetailRepo orderDetailRepo;

  public Iterable<OrderDetail> findAll() {
    return orderDetailRepo.findAll();
  }

  public Iterable<OrderDetail> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return orderDetailRepo.findAll(pageable).getContent();
  }

  public Iterable<OrderDetail> findAllByOrder(Order order) {
    return orderDetailRepo.findAllByOrder(order);
  }

  public Optional<OrderDetail> findById(int id) {
    return orderDetailRepo.findById(id);
  }

  public boolean deleteById(int id) {
    orderDetailRepo.deleteById(id);
    return true;
  }

  public OrderDetail save(OrderDetail data) {
    return orderDetailRepo.save(data);
  }
}