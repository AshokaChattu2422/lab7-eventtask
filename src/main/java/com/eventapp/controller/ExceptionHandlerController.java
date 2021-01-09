package com.eventapp.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eventapp.exceptions.ErrorDetails;
import com.eventapp.exceptions.EventNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EventNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(EventNotFoundException ex,
			WebRequest request) {
		ErrorDetails details=new ErrorDetails();
		details.setErrorMessage(request.getDescription(false));
		details.setContact("ashoka@gmail.com");
		details.setTimestamp(new Date());
		details.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> serverSideEandleAllExceptions(Exception ex,
			WebRequest request) {
		ErrorDetails details=new ErrorDetails();
		details.setErrorMessage("some server side problem,try again");
		details.setContact("ashoka@gmail.com");
		details.setTimestamp(new Date());
		details.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}