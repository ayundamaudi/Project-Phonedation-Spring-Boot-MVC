package com.bca.repositories;

import java.util.List;

import com.bca.entities.Order;
import com.bca.entities.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends PagingAndSortingRepository<Order, String> {
  public List<Order> findByUser(User user);

  public List<Order> findAllByUserAndCheckoutDateIsNotNull(User user);

  public List<Order> findAllByCheckoutDateIsNotNullOrderByCheckoutDateDesc();
}