package com.eventapp.service;


import java.time.LocalDate;
import java.util.List;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancelRequest;
import com.eventapp.dto.TicketCancelResponse;
import com.eventapp.entities.Event;

public interface EventService {

	public List<Event> getAllEvents() ;
	public Event getEventById(int eventId) ;
	public Event addEvent(Event event);
	public Event updateEvent(int eventId, Event event);
	public Event deleteEvent(int bookId);
	public Event findByUserName(String username);
	public TicketBookingResponse bookTickets (TicketBookingRequest request);
	public TicketCancelResponse bookTickets (TicketCancelRequest request);
	public List<Event>findByEventDateBetween(LocalDate date1,LocalDate date2);
	//TicketCancelResponse cancelTickets(TicketCancelRequest request);
	TicketCancelResponse cancelTickets(TicketCancelRequest request);

	
}
