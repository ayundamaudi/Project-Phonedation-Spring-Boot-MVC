package com.bca.repositories;

import com.bca.entities.Ewallet;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EwalletRepo extends PagingAndSortingRepository<Ewallet, Integer> {

}
