package com.bca.repositories;

import com.bca.entities.TransactionEwallet;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionEwalletRepo extends PagingAndSortingRepository<TransactionEwallet, Integer> {

}
