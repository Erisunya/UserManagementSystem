package com.cognizant.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Username is not in database!")
public class UsernameNotFoundException extends Exception{

}
