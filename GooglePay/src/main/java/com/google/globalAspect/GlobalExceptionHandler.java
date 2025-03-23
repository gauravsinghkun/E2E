package com.google.globalAspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.google.error.ErrorDetails;
import com.google.exception.AccountNotExistException;
import com.google.exception.NoAccountsInDBException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AccountNotExistException.class)
	public ResponseEntity<ErrorDetails> exception_1(AccountNotExistException exception) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorId(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = NoAccountsInDBException.class)
	public ResponseEntity<ErrorDetails> exception_1(NoAccountsInDBException exception) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorId(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
