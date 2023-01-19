package com.finance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.finance.entity.User;

public interface UserRepository  extends MongoRepository<User, Integer>{

	@Query("{ 'userName' : ?0 }")
	User findUserByUsername(String username);
}
