package com.bca.services;

import java.util.Optional;

import com.bca.entities.Wishlist;
import com.bca.repositories.WishlistRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WishlistService {

  @Autowired
  private WishlistRepo wishlistRepo;

  public Iterable<Wishlist> findAll() {
    return wishlistRepo.findAll();
  }

  public Iterable<Wishlist> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return wishlistRepo.findAll(pageable).getContent();
  }

  public Optional<Wishlist> findById(int id) {
    return wishlistRepo.findById(id);
  }

  public boolean deleteById(int id) {
    wishlistRepo.deleteById(id);
    return true;
  }

  public Wishlist save(Wishlist data) {
    return wishlistRepo.save(data);
  }
}