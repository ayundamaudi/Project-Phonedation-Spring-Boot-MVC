package com.bca.repositories;

import com.bca.entities.OrderDetail;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail, Integer> {

}
