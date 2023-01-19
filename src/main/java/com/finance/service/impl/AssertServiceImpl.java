package com.finance.service.impl;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dto.AddAssertRequest;
import com.finance.dto.Response;
import com.finance.entity.Assert;
import com.finance.exception.AssertException;
import com.finance.repository.AssertRepository;
import com.finance.service.AssertService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AssertServiceImpl implements AssertService {

	@Autowired 
	AssertRepository assertRepository;
	
	@Override
	public Response addAssertDetails(AddAssertRequest assertRequest) {
		Response response=new Response();
		try {
			log.info("addAssertDetails started");
			if(assertRequest!=null && assertRequest.getAssertType()!=null && assertRequest.getInvestmentAmount()!=0) {
				Assert assertObj=new Assert();
				assertObj.setAssertType(assertRequest.getAssertType());
				assertObj.setInvestmentType(assertRequest.getInvestmentType());
				assertObj.setInvestmentDate(assertRequest.getInvestmentDate());
				assertObj.setInvestmentAmount(assertRequest.getInvestmentAmount());
				assertObj.setComment(assertRequest.getComment());
				assertObj.setUserName(assertRequest.getUserName());
				Assert result = assertRepository.insert(assertObj);
				if(result!=null) {
					log.info("assert details inserted into DB");
					response.setData(200);
					response.setMessage("Assert Details inserted: "+result);
				}else {
					log.info("failed to insert assert details into DB");
					response.setData(500);
					response.setMessage("Failed to insert details");
				}
			}else {
				log.info("Some inputs are empty in addAssertDetails");
				response.setData(400);
				response.setMessage("Some input are empty.");
			}
		} catch (Exception e) {
			log.error("Error in addAssertDetails service: {}",ExceptionUtils.getStackTrace(e));
			throw new AssertException(e);
		}
		return response;
	}

}
