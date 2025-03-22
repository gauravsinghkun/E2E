package com.irctc.exception;

public class NoTicketsInDBException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTicketsInDBException(String message) {
		super(message);
	}
}
