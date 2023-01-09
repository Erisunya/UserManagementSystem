package com.cognizant.bank.services;

import com.cognizant.bank.exceptions.UsernameExistsException;
import com.cognizant.bank.model.UserRequest;

public interface UserAuthService {
	
	public void saveUser(UserRequest userRequest) throws UsernameExistsException;
	
	public boolean validateUser(String username, String password);
	
}
