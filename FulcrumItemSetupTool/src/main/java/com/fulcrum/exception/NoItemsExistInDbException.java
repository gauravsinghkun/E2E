package com.fulcrum.exception;

public class NoItemsExistInDbException extends RuntimeException {

	public NoItemsExistInDbException(String message) {
		super(message);
	}
}
