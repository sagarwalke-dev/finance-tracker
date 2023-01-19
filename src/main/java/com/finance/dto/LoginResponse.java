package com.finance.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LoginResponse extends Response{

	private String userId;
	private String userName;
	private String token;
	private Timestamp loginTime;

}
