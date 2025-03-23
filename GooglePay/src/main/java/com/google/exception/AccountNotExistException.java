package com.google.exception;

public class AccountNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotExistException(String message) {
		super(message);
	}
}
