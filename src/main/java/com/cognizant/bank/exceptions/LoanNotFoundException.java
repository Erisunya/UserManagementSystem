package com.cognizant.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="This user does not have a loan.")
public class LoanNotFoundException extends Exception{

}
