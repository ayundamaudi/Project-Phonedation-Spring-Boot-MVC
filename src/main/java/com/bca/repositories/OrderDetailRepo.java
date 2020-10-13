package com.bca.repositories;

import java.util.List;

import com.bca.entities.Order;
import com.bca.entities.OrderDetail;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail, Integer> {
  public List<OrderDetail> findAllByOrder(Order order);
}
