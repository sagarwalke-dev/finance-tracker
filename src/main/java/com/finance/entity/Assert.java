package com.finance.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "assert")
@Data
public class Assert {
	@Id
	private String assertId;
	private String userName;
	private String investmentType;
	private String assertType;
	private Date investmentDate;
	private Integer investmentAmount;
	private String comment;
}