package com.fatec.antenas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CredentialNotFoundException extends RuntimeException{
	public CredentialNotFoundException(String message) {
		super(message);
	}
}
