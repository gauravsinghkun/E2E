package com.zomato.restExcpetionAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.zomato.errorClass.ErrorClass;
import com.zomato.exception.ItemFulfillmentException;
import com.zomato.exception.NoSourcingEventsException;

@Component
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = ItemFulfillmentException.class)
	public ResponseEntity<ErrorClass> exception_1(ItemFulfillmentException ex){
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorId(1001);
		errorClass.setErrorMessage(ex.getMessage());
		ResponseEntity<ErrorClass> responseEntity = new ResponseEntity<ErrorClass>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}

	@ExceptionHandler(value = NoSourcingEventsException.class )
	public ResponseEntity<ErrorClass> exception_2(NoSourcingEventsException ex){
		ErrorClass errorClass = new ErrorClass();
		errorClass.setErrorId(1002);
		errorClass.setErrorMessage(ex.getMessage());
		ResponseEntity<ErrorClass> responseEntity = new ResponseEntity<ErrorClass>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
}
