package com.bca.services;

import java.util.Optional;

import com.bca.entities.Brand;
import com.bca.repositories.BrandRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandService {

  @Autowired
  private BrandRepo brandRepo;

  public Iterable<Brand> findAll() {
    return brandRepo.findAll();
  }

  public Iterable<Brand> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return brandRepo.findAll(pageable).getContent();
  }

  public Optional<Brand> findById(int id) {
    return brandRepo.findById(id);
  }

  public boolean deleteById(int id) {
    brandRepo.deleteById(id);
    return true;
  }

  public Brand save(Brand data) {
    return brandRepo.save(data);
  }
}
