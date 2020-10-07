package com.bca.repositories;

import com.bca.entities.Wishlist;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface WishlistRepo extends PagingAndSortingRepository<Wishlist, Integer> {

}
