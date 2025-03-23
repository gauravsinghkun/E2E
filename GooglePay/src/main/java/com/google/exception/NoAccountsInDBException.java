package com.google.exception;

public class NoAccountsInDBException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAccountsInDBException(String message) {
		super(message);
	}
}
