package com.bca.repositories;

import com.bca.entities.PostalCode;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalCodeRepo extends PagingAndSortingRepository<PostalCode, Integer> {

}
