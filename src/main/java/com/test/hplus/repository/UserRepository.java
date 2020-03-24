package com.test.hplus.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.hplus.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("select u from User u where u.username= :name")
  public User searchByName(@Param("name") String username);
}
