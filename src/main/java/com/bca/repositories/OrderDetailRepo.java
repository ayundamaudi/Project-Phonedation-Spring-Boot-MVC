package com.bca.repositories;

import java.util.List;

import com.bca.entities.Order;
import com.bca.entities.OrderDetail;
import com.bca.entities.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail, Integer> {
  public List<OrderDetail> findAllByOrder(Order order);

  public OrderDetail findByOrderAndProduct(Order order, Product product);
}
