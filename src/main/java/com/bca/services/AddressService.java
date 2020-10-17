package com.bca.services;

import java.util.Optional;

import com.bca.entities.Address;
import com.bca.entities.PostalCode;
import com.bca.repositories.AddressRepo;
import com.bca.repositories.PostalCodeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService {

  @Autowired
  private AddressRepo addressRepo;

  @Autowired
  private PostalCodeRepo postalCodeRepo;

  public Iterable<Address> findAll() {
    return addressRepo.findAll();
  }

  public Iterable<Address> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return addressRepo.findAll(pageable).getContent();
  }

  public Optional<Address> findById(int id) {
    return addressRepo.findById(id);
  }

  public boolean deleteById(int id) {
    addressRepo.deleteById(id);
    return true;
  }

  public Address save(Address data) {
    return addressRepo.save(data);
  }

  public PostalCode findPostalCodeById(String id) {
    return postalCodeRepo.findById(id).get();
  }
}