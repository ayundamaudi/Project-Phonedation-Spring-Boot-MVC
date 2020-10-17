package com.bca.services;

import java.util.Optional;

import com.bca.entities.PostalCode;
import com.bca.repositories.PostalCodeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostalCodeService {

  @Autowired
  private PostalCodeRepo postalCodeRepo;

  public Iterable<PostalCode> findAll() {
    return postalCodeRepo.findAll();
  }

  public Iterable<PostalCode> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return postalCodeRepo.findAll(pageable).getContent();
  }

  public Optional<PostalCode> findById(String id) {
    return postalCodeRepo.findById(id);
  }

  public boolean deleteById(String id) {
    postalCodeRepo.deleteById(id);
    return true;
  }

  public PostalCode save(PostalCode data) {
    return postalCodeRepo.save(data);
  }
}
