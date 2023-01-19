package com.finance.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AddAssertRequest {
	private String userName;
	private String investmentType;
	private String assertType;
	private Date investmentDate;
	private Integer investmentAmount;
	private String comment;
}
