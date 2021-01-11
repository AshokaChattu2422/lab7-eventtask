package com.eventapp.dto;

public class TicketBookingRequest {
	private  int eventid;
	private int noOftickets;
	
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public int getNoOftickets() {
		return noOftickets;
	}
	public void setNoOftickets(int noOftickets) {
		this.noOftickets = noOftickets;
	}
	
}
