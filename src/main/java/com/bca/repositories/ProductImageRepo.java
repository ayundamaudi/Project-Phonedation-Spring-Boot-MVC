package com.bca.repositories;

import com.bca.entities.ProductImage;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductImageRepo extends PagingAndSortingRepository<ProductImage, Integer> {

}
