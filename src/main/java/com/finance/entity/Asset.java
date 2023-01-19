package com.finance.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "asset")
@Data
public class Asset {
	@Id
	private String assetId;
	private String userName;
	private String investmentType;
	private String assetType;
	private Date investmentDate;
	private Integer investmentAmount;
	private String comment;
}