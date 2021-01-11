package com.eventapp.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EventNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = -4465236137021151482L;

	public EventNotFoundException(String message) {
		super(message);
	}
	
}
