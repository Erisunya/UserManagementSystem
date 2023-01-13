package com.cognizant.bank.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
	
	private String name;
	private String username;
	private String password;
	private String address;
	private String country;
	private String email;
	private long accountNo;
	private long contactNo;
	private Date dob;
	private String accountType;
	
}
