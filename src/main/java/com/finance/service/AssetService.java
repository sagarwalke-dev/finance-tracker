package com.finance.service;

import com.finance.dto.AddAssetRequest;
import com.finance.dto.LoginRequest;
import com.finance.dto.LoginResponse;
import com.finance.dto.Response;

/**
 * @author sagar
 *
 */
public interface AssetService {

	public Response addAssetDetails(AddAssetRequest assetRequest);
}
