package com.finance.service;

import com.finance.dto.AddAssertRequest;
import com.finance.dto.LoginRequest;
import com.finance.dto.LoginResponse;
import com.finance.dto.Response;

/**
 * @author sagar
 *
 */
public interface AssertService {

	public Response addAssertDetails(AddAssertRequest assertRequest);
}
