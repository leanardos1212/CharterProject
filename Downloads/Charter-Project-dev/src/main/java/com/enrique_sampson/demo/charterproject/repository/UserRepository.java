package com.enrique_sampson.demo.charterproject.repository;

import com.enrique_sampson.demo.charterproject.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}