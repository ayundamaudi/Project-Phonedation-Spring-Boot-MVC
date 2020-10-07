package com.bca.services;

import java.util.Optional;

import com.bca.entities.PaymentMethod;
import com.bca.repositories.PaymentMethodRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentMethodService {

  @Autowired
  private PaymentMethodRepo paymentMethodRepo;

  public Iterable<PaymentMethod> findAll() {
    return paymentMethodRepo.findAll();
  }

  public Iterable<PaymentMethod> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return paymentMethodRepo.findAll(pageable).getContent();
  }

  public Optional<PaymentMethod> findById(int id) {
    return paymentMethodRepo.findById(id);
  }

  public boolean deleteById(int id) {
    paymentMethodRepo.deleteById(id);
    return true;
  }

  public PaymentMethod save(PaymentMethod data) {
    return paymentMethodRepo.save(data);
  }
}
