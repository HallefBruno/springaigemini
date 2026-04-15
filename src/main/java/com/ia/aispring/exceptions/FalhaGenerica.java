package com.ia.aispring.exceptions;

import org.springframework.http.HttpStatus;


public class FalhaGenerica extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;

	public FalhaGenerica(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
}
