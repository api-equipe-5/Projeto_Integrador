package com.fatec.antenas.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ResourceAlreadyExistsException extends RuntimeException{
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}
}
