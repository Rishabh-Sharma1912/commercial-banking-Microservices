package com.bankingsample.microservices.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3725300023812093506L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
