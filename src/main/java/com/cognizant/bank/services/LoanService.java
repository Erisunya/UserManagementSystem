package com.cognizant.bank.services;

import com.cognizant.bank.entities.User;
import com.cognizant.bank.exceptions.UsernameNotFoundException;
import com.cognizant.bank.model.LoanRequest;

public interface LoanService {
	
	public User viewLoan(LoanRequest loanRequest) throws UsernameNotFoundException;
	
	public void saveLoan(LoanRequest loanRequest) throws UsernameNotFoundException;
	
}
