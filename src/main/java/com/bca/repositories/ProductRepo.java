package com.bca.repositories;

import com.bca.entities.Product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

}
