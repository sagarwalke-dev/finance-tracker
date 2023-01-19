package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.entity.User;
import com.finance.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@GetMapping("/test")
	public String testApp() {
		User user=new User();
		user.setUserId("1");
		user.setUserName("abc");
		repository.save(user);
		return "success";
	}
}
