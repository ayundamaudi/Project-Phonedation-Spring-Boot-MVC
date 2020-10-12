package com.bca.repositories;

import com.bca.entities.Order;
import com.bca.entities.Product;
import com.bca.entities.User;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

	public List<Product> findAllByModel(String model, Pageable pageable);

	public List<Product> findAllByOrderByDateCreatedDesc(Pageable pageable);

	public List<Product> findAllByOrderBySoldDesc(Pageable pageable);

	public List<Product> findAllByWishlistsUser(User user);

	public List<Product> findAllByOrderDetailsOrder(Order order);
}
