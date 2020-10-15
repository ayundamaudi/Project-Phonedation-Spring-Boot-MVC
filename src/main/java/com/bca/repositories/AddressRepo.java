package com.bca.repositories;

import com.bca.entities.Address;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends PagingAndSortingRepository<Address, Integer> {

}
