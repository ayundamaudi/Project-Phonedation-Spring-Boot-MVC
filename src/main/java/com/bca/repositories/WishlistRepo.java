package com.bca.repositories;

import java.util.List;

import com.bca.entities.User;
import com.bca.entities.Wishlist;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends PagingAndSortingRepository<Wishlist, Integer> {
  public List<Wishlist> findAllByUser(User user);
}
