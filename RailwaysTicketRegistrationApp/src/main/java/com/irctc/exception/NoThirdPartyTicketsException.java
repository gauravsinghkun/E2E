package com.irctc.exception;

public class NoThirdPartyTicketsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoThirdPartyTicketsException(String message) {
		super(message);
	}
}
