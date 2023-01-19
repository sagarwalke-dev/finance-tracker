package com.finance.service;

import com.finance.dto.LoginRequest;
import com.finance.dto.LoginResponse;

/**
 * @author sagar
 *
 */
public interface AuthenticationService {

	/**
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse loginUser(LoginRequest loginRequest );
	
	public Boolean validateUser(String token);
}
