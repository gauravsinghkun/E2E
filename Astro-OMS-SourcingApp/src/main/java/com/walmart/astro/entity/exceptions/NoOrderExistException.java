package com.walmart.astro.entity.exceptions;

public class NoOrderExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NoOrderExistException(String message) {
		super(message);
	}
}
