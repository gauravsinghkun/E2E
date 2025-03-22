package com.irctc.exception;

public class PnrInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PnrInvalidException(String message) {
		super(message);
	}
}
