package com.cognizant.bank.controller;

import java.util.List;
import java.util.Optional;

import com.cognizant.bank.entities.User;
import com.cognizant.bank.model.UserRequest;
import com.cognizant.bank.repositories.UserRepository;

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
public class BankController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/user/find/{id}")
	public ResponseEntity<?> testMethod (@PathVariable("id") Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			return new ResponseEntity<String>("User not found", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Found!", HttpStatus.OK);
	}

}
