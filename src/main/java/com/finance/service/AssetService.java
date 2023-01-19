package com.finance.service;

import com.finance.dto.AddAssetRequest;
import com.finance.dto.Response;

/**
 * @author sagar
 *
 */
public interface AssetService {

	public Response addAssetDetails(AddAssetRequest assetRequest);
}
