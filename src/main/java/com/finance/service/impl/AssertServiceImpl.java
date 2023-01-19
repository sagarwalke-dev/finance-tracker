package com.finance.service.impl;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dto.AddAssetRequest;
import com.finance.dto.Response;
import com.finance.entity.Asset;
import com.finance.exception.AssetException;
import com.finance.repository.AssetRepository;
import com.finance.service.AssetService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AssertServiceImpl implements AssetService {

	@Autowired 
	AssetRepository assertRepository;
	
	@Override
	public Response addAssetDetails(AddAssetRequest assertRequest) {
		Response response=new Response();
		try {
			log.info("addAssetDetails started");
			if(assertRequest!=null && assertRequest.getAssertType()!=null && assertRequest.getInvestmentAmount()!=0) {
				Asset assertObj=new Asset();
				assertObj.setAssetType(assertRequest.getAssertType());
				assertObj.setInvestmentType(assertRequest.getInvestmentType());
				assertObj.setInvestmentDate(assertRequest.getInvestmentDate());
				assertObj.setInvestmentAmount(assertRequest.getInvestmentAmount());
				assertObj.setComment(assertRequest.getComment());
				assertObj.setUserName(assertRequest.getUserName());
				Asset result = assertRepository.insert(assertObj);
				if(result!=null) {
					log.info("asset details inserted into DB");
					response.setData(200);
					response.setMessage("Asset Details inserted: "+result);
				}else {
					log.info("failed to insert asset details into DB");
					response.setData(500);
					response.setMessage("Failed to insert details");
				}
			}else {
				log.info("Some inputs are empty in addAssetDetails");
				response.setData(400);
				response.setMessage("Some input are empty.");
			}
		} catch (Exception e) {
			log.error("Error in addAssetDetails service: {}",ExceptionUtils.getStackTrace(e));
			throw new AssetException(e);
		}
		return response;
	}

}
