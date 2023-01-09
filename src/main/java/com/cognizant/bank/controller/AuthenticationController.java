package com.cognizant.bank.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cognizant.bank.entities.User;
import com.cognizant.bank.exceptions.UsernameExistsException;
import com.cognizant.bank.model.UserRequest;
import com.cognizant.bank.services.UserAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping("auth/user")
public class AuthenticationController {
	
	@Autowired
	private UserAuthService userAuthService;
	private Map<String, String> authObj = new HashMap<String, String>();
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody UserRequest userRequest) throws UsernameExistsException {
		
		userAuthService.saveUser(userRequest);
		
		return new ResponseEntity<String>("User registered successfully", HttpStatus.OK);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User userRequest) {
		
		try {
			String jwtToken = generateToken(userRequest.getUsername(), userRequest.getPassword());
			authObj.put("Message", "Login succeeded!.");
			authObj.put("Token", jwtToken);
		} catch (Exception e) {	
			authObj.put("Message", "Login failed.");
			authObj.put("Token", null);
		}
		
		return new ResponseEntity<>(authObj, HttpStatus.OK);
		
	}
	
	public String generateToken(String username, String password) throws ServletException {
		
		String jwtToken = null;
		
		if(username == null || password == null) {
			throw new ServletException("Please enter username/password.");
		}
		
		boolean isValidated = userAuthService.validateUser(username, password);
		
		if(!isValidated) {
			throw new ServletException("Username or password is invalid.");
		}
		
		jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000000))
				.signWith(SignatureAlgorithm.HS256, "secret key")
				.compact();
		
		return jwtToken;
	}
	
	
}
