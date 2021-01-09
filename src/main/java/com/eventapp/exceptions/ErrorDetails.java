package com.eventapp.exceptions;

import java.util.Date;

public class ErrorDetails {
	private String errorMessage;
	private Date timestamp;
	  private String message;
	  private String contact;
	  
	  
	public ErrorDetails() {
		
	}



	public ErrorDetails(String errorMessage, Date timestamp, String message, String contact) {
		super();
		this.errorMessage = errorMessage;
		this.timestamp = timestamp;
		this.message = message;
		this.contact = contact;
	}
	
	  
	  
		public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
		
	
		
}
