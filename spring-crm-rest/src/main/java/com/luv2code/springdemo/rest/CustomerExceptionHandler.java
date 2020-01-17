package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorRespoose> handleException(CustomerNotFoundException ex)
	{
		CustomerErrorRespoose thecusCustomerErrorRespoose = new CustomerErrorRespoose();
		thecusCustomerErrorRespoose.setMessage(ex.getMessage());
		thecusCustomerErrorRespoose.setStatus(HttpStatus.NOT_FOUND.value());
		thecusCustomerErrorRespoose.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(thecusCustomerErrorRespoose,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<CustomerErrorRespoose> handleException(Exception ex)
	{
		CustomerErrorRespoose thecusCustomerErrorRespoose = new CustomerErrorRespoose();
		thecusCustomerErrorRespoose.setMessage(ex.getMessage());
		thecusCustomerErrorRespoose.setStatus(HttpStatus.BAD_REQUEST.value());
		thecusCustomerErrorRespoose.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(thecusCustomerErrorRespoose,HttpStatus.BAD_REQUEST);
	}
	

}
