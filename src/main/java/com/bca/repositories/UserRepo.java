package com.bca.repositories;

import com.bca.entities.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends PagingAndSortingRepository<User, Integer> {
  public User findByEmail(String email);

  public User findByEmailAndPassword(String email, String password);
}
