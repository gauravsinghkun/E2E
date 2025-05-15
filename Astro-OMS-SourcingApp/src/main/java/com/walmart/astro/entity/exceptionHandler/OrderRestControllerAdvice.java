package com.walmart.astro.entity.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.walmart.astro.entity.errorClass.ErrorClass;
import com.walmart.astro.entity.exceptions.NoOrderExistException;
import com.walmart.astro.entity.exceptions.NoOrdersInDbException;

@RestControllerAdvice
public class OrderRestControllerAdvice {

	@ExceptionHandler(value = NoOrdersInDbException.class)
	public ResponseEntity<ErrorClass> exception_1(NoOrdersInDbException ex){
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorClass.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorClass>(errorClass,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NoOrderExistException.class)
	public ResponseEntity<ErrorClass> exception_2(NoOrderExistException ex){
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorClass.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorClass>(errorClass,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
