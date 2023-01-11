package com.cognizant.bank.model;

import java.util.Date;

import com.cognizant.bank.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
	
	private String username;
	private String loanType;
	private long loanAmount;
	private Date loanDate;
	private long loanDuration;
	private long interestRate;
	
}
