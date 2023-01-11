package com.cognizant.bank.controller;

import java.util.List;
import java.util.Optional;

import com.cognizant.bank.entities.Loan;
import com.cognizant.bank.entities.User;
import com.cognizant.bank.exceptions.LoanNotFoundException;
import com.cognizant.bank.exceptions.UsernameNotFoundException;
import com.cognizant.bank.model.UserRequest;
import com.cognizant.bank.repositories.UserRepository;
import com.cognizant.bank.services.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/{username}")
	public Loan showLoan(@PathVariable("username") String username) throws UsernameNotFoundException, LoanNotFoundException {
		
		return loanService.viewLoan(username);
	}
}
