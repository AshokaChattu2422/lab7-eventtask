package com.eventapp.service;

import java.awt.print.Book;
import java.util.List;

import com.eventapp.entities.Event;

public interface EventService {

	public List<Event> getAllEvents() ;
	public Event getEventById(int eventId) ;
	public Event addEvent(Event event);
	public Event updateEvent(int eventId, Event event);
	public Event deleteEvent(int bookId);
	public Event findByUserName(String username);

}
