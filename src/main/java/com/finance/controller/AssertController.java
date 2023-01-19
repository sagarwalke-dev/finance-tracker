package com.finance.controller;

import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.dto.AddAssertRequest;
import com.finance.dto.LoginResponse;
import com.finance.dto.Response;
import com.finance.service.AssertService;
import com.finance.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/fund/")
@Slf4j
public class AssertController {

	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	AssertService assertService;

	@PostMapping("/add")
	public ResponseEntity<Response> addAssert(@RequestBody AddAssertRequest request, @RequestHeader Map<String, String> header) {
		Response serviceResponse = new Response();
		ResponseEntity<Response> response = null;
		try {
			log.info("addAssert controller started for: {}", request.getUserName());
			Boolean isValidUser=authenticationService.validateUser(header.get("token"));
			log.info(request.getUserName()+" user is valid: {}",isValidUser);
			serviceResponse=assertService.addAssertDetails(request);
			log.info("addAssertDetails service response: {}",serviceResponse);
			response=new ResponseEntity<Response>(serviceResponse, HttpStatus.valueOf(serviceResponse.getData()));
		} catch (Exception e) {
			log.error("Error in addAssert controller: {}", ExceptionUtils.getStackTrace(e));
			response=new ResponseEntity<Response>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("addAssert controller completed for: {}", request.getUserName());
		return response;
	}
}
