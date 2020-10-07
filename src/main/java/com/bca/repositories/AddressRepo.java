package com.bca.repositories;

import com.bca.entities.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepo extends PagingAndSortingRepository<Address, Integer> {

}
