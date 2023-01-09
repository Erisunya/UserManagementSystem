package com.cognizant.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Username exists in database! Please log in instead.")
public class UsernameExistsException extends Exception{

}
