package com.walmart.astro.entity.exceptions;

public class NoOrdersInDbException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NoOrdersInDbException(String message) {
		super(message);
	}
}
