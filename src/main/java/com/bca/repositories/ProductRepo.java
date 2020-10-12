package com.bca.repositories;

import com.bca.entities.Product;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

	public List<Product> findAllByModel(String model, Pageable pageable);

	public List<Product> findAllOrderByCreatedDateAsc(Pageable pageable);

	public List<Product> findAllOrderBySoldDesc(Pageable pageable);
}
