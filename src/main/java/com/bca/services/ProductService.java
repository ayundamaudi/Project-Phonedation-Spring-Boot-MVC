package com.bca.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bca.entities.Product;
import com.bca.repositories.ProductRepo;

@Service("productService")
@Transactional 
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public Iterable<Product> findAll(){
		return productRepo.findAll();
	}
	
	public List<Product> findAll(int page, int rows){
		Pageable pageable = PageRequest.of(page-1,rows);
		return productRepo.findAll(pageable).getContent();
	}
	
	public List<Product> findAllByModel(String model, int page){
		Pageable pageable = PageRequest.of(page,10);
		return productRepo.findAllByModel(model, pageable);
	}
	
	public Optional<Product> findById(int id){
		return productRepo.findById(id);
	}
	
	public boolean delete(int id) {
		productRepo.deleteById(id);
		return true;
	}
}
