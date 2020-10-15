package com.bca.repositories;

import com.bca.entities.PaymentMethod;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends PagingAndSortingRepository<PaymentMethod, Integer> {

}
