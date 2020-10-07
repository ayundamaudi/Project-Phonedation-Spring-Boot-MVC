package com.bca.repositories;

import com.bca.entities.Order;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepo extends PagingAndSortingRepository<Order, Integer> {

}
