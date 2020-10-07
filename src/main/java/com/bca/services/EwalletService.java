package com.bca.services;

import java.util.Optional;

import com.bca.entities.Ewallet;
import com.bca.repositories.EwalletRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EwalletService {

  @Autowired
  private EwalletRepo ewalletRepo;

  public Iterable<Ewallet> findAll() {
    return ewalletRepo.findAll();
  }

  public Iterable<Ewallet> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return ewalletRepo.findAll(pageable).getContent();
  }

  public Optional<Ewallet> findById(int id) {
    return ewalletRepo.findById(id);
  }

  public boolean deleteById(int id) {
    ewalletRepo.deleteById(id);
    return true;
  }

  public Ewallet save(Ewallet data) {
    return ewalletRepo.save(data);
  }
}
