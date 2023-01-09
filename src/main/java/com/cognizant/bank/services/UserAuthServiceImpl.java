package com.cognizant.bank.services;

import java.util.Optional;

import com.cognizant.bank.entities.User;
import com.cognizant.bank.exceptions.UsernameExistsException;
import com.cognizant.bank.model.UserRequest;
import com.cognizant.bank.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl {
	
	@Autowired
	private UserRepository userRepository;

	public void saveUser(UserRequest userRequest) throws UsernameExistsException {
		
		if(userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
			throw new UsernameExistsException();
		} 
		
		User user = new User();
		user.setName(userRequest.getName());
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		user.setAddress(userRequest.getAddress());
		user.setCountry(userRequest.getCountry());
		user.setEmail(userRequest.getEmail());
		user.setAccountNo(userRequest.getAccountNo());
		user.setContactNo(userRequest.getContactNo());
		user.setDob(userRequest.getDob());
		user.setAccountType(userRequest.getAccountType());
		user.setRole(userRequest.getRole());
		
		userRepository.saveAndFlush(user);
	}
	
	public boolean validateUser(String username, String password) {
		
		Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
		
		if(user.isEmpty()) {
			return false;
		}
		
		return true;
		
	}
}
