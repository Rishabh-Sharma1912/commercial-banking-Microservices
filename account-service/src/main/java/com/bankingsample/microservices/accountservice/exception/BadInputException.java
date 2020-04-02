package com.bankingsample.microservices.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadInputException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3725300023812093506L;

	public BadInputException(String message) {
		super(message);
	}
}
