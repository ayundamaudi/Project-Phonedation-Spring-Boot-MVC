package com.bca.repositories;

import com.bca.entities.PaymentMethod;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentMethodRepo extends PagingAndSortingRepository<PaymentMethod, Integer> {

}
