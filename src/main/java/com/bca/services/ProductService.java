package com.bca.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bca.entities.Order;
import com.bca.entities.Product;
import com.bca.entities.User;
import com.bca.repositories.ProductRepo;

@Service("productService")
@Transactional
public class ProductService {

	private int MAX_LATEST_PRODUCT = 10;
	private int MAX_BESTSELLER_PRODUCT = 10;

	@Autowired
	private ProductRepo productRepo;

	public Product save(Product product) {
		return productRepo.save(product);
	}

	public Iterable<Product> findAll() {
		return productRepo.findAll();
	}

	public List<Product> findAll(int page, int rows) {
		Pageable pageable = PageRequest.of(page - 1, rows);
		return productRepo.findAll(pageable).getContent();
	}

	public List<Product> findAllByModel(String model, int page) {
		Pageable pageable = PageRequest.of(page - 1, 10);
		return productRepo.findAllByModel(model, pageable);
	}

	public Optional<Product> findById(int id) {
		return productRepo.findById(id);
	}

	public boolean delete(int id) {
		productRepo.deleteById(id);
		return true;
	}

	public List<Product> findLatestProducts() {
		Pageable pageable = PageRequest.of(0, this.MAX_LATEST_PRODUCT);
		return productRepo.findAllByOrderByDateCreatedDesc(pageable);
	}

	public List<Product> findBestsellerProducts() {
		Pageable pageable = PageRequest.of(0, this.MAX_BESTSELLER_PRODUCT);
		return productRepo.findAllByOrderBySoldDesc(pageable);
	}

	public List<Product> findWishlistedProductsByUser(User user) {
		return productRepo.findAllByWishlistsUser(user);
	}

	public List<Product> findProductsByOrder(Order cart) {
		return productRepo.findAllByOrderDetailsOrder(cart);
	}
}
