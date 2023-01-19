package com.finance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.finance.entity.Asset;

public interface AssetRepository  extends MongoRepository<Asset, String>{

}
