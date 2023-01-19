package com.finance.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dto.LoginRequest;
import com.finance.dto.LoginResponse;
import com.finance.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth/")
@Slf4j
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
		LoginResponse loginResponse = null;
		ResponseEntity<LoginResponse> response = null;
		try {
			log.info("loginUser controller started for: {}", request.getUserName());
			loginResponse = authenticationService.loginUser(request);
			response = new ResponseEntity<LoginResponse>(loginResponse,
					HttpStatus.valueOf(loginResponse.getData()));
		} catch (Exception e) {
			log.error("Error in loginUser controller: {}", ExceptionUtils.getStackTrace(e));
			response = new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("loginUser controller completed for: {}", request.getUserName());
		return response;
	}
}
