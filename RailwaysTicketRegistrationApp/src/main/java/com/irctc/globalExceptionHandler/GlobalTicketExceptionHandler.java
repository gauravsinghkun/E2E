package com.irctc.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irctc.errorClass.ErrorClass;
import com.irctc.exception.NoThirdPartyTicketsException;
import com.irctc.exception.NoTicketsInDBException;
import com.irctc.exception.PnrInvalidException;
import com.irctc.exception.TicketBookingException;

@RestControllerAdvice
public class GlobalTicketExceptionHandler {

	@ExceptionHandler(value = NoThirdPartyTicketsException.class)
	public ResponseEntity<ErrorClass> exception_1(NoThirdPartyTicketsException exception) {
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorClass.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorClass>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = NoTicketsInDBException.class)
	public ResponseEntity<ErrorClass> exception_2(NoTicketsInDBException exception) {
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorClass.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorClass>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = PnrInvalidException.class)
	public ResponseEntity<ErrorClass> exception_3(PnrInvalidException exception) {
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorClass.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorClass>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = TicketBookingException.class)
	public ResponseEntity<ErrorClass> exception_4(TicketBookingException exception) {
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorClass.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorClass>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
