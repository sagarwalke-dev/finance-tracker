package com.finance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.finance.entity.Assert;

public interface AssertRepository  extends MongoRepository<Assert, String>{

}
