package com.bca.repositories;

import com.bca.entities.Brand;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepo extends PagingAndSortingRepository<Brand, Integer> {

}
