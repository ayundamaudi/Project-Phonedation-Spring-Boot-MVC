package com.bca.repositories;

import com.bca.entities.PostalCode;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostalCodeRepo extends PagingAndSortingRepository<PostalCode, Integer> {

}
