package com.joshua.addressbook.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1311196738645554021L;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
