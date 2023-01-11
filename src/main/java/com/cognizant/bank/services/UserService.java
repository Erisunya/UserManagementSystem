package com.cognizant.bank.services;

import com.cognizant.bank.exceptions.UsernameNotFoundException;
import com.cognizant.bank.model.UserRequest;

public interface UserService {
	
	public void updateUser(UserRequest userRequest) throws UsernameNotFoundException;
	
}
