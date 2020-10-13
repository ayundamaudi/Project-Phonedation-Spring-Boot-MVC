package com.bca.repositories;

import java.util.List;

import com.bca.entities.Order;
import com.bca.entities.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepo extends PagingAndSortingRepository<Order, Integer> {
  public List<Order> findByUser(User user);
}
