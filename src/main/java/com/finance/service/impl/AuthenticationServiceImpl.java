package com.finance.service.impl;

import java.sql.Timestamp;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dto.LoginRequest;
import com.finance.dto.LoginResponse;
import com.finance.entity.User;
import com.finance.exception.AuthenticationException;
import com.finance.repository.UserRepository;
import com.finance.service.AuthenticationService;
import com.finance.util.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	JwtTokenUtil tokenUtil;

	@Override
	public LoginResponse loginUser(LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		try {
			log.info("loginUser service started");
			if (loginRequest != null && loginRequest.getUserName() != null) {
				// perform login action
				User user = userRepository.findUserByUsername(loginRequest.getUserName());
				log.info("user: {}", user);
				if (user != null) {
					log.info("user found - validating password");
					if (user.getPassword().equals(loginRequest.getPassword())) {
						log.info(loginRequest.getUserName() + " valid user");
						// generate JWT
						String token = tokenUtil.generateToken(user);
						loginResponse.setData(200);
						loginResponse.setMessage("Sucess");
						loginResponse.setUserName(loginRequest.getUserName());
						loginResponse.setUserId(user.getUserId());
						loginResponse.setLoginTime(new Timestamp(System.currentTimeMillis()));
						loginResponse.setToken(token);
					} else {
						log.info("invalid credentials");
						loginResponse.setData(401);
						loginResponse.setMessage("Invalid credentials");
					}
				} else {
					log.info("user not found");
					loginResponse.setData(404);
					loginResponse.setMessage("User not found");
				}
			} else {
				log.info("Bad request some inputs are empty");
				loginResponse.setData(400);
				loginResponse.setMessage("Bad Request");
			}
		} catch (Exception e) {
			log.error("Error in loginUser service");
			throw new AuthenticationException(e);
		}
		log.info("loginUser service completed");
		return loginResponse;
	}

	@Override
	public Boolean validateUser(String token) {
		try {
			log.info("validateUser service started");
			String username=tokenUtil.getUsernameFromToken(token);
			log.info("username retrived from token: {}",username);
			// check in cache 
			return true;
		} catch (Exception e) {
			log.error("Error in validateUser service");
			throw new AuthenticationException(e);
		}
	}

}
