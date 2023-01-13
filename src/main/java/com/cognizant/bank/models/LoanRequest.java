package com.cognizant.bank.models;

import java.util.Date;

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
