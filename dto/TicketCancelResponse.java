package com.eventapp.dto;

public class TicketCancelResponse {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmountReturned() {
		return amountReturned;
	}
	public void setAmountReturned(double amountReturned) {
		this.amountReturned = amountReturned;
	}
	private double amountReturned;
	

}
