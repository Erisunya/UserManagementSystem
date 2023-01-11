package com.cognizant.bank.services;

import java.util.Optional;

import com.cognizant.bank.entities.User;
import com.cognizant.bank.exceptions.UsernameNotFoundException;
import com.cognizant.bank.model.UserRequest;
import com.cognizant.bank.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void updateUser(UserRequest userRequest) throws UsernameNotFoundException {
		
		Optional<User> userOp = userRepository.findByUsername(userRequest.getUsername());
		
		if(userOp.isEmpty()) {
			throw new UsernameNotFoundException();
		}
		
		User user = userOp.get();
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
		
		userRepository.saveAndFlush(user);
	}

}
