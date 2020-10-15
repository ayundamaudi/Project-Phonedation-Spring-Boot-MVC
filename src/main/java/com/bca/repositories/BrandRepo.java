package com.bca.repositories;

import com.bca.entities.Brand;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends PagingAndSortingRepository<Brand, Integer> {

}
