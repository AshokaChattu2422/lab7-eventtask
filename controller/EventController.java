package com.eventapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancelResponse;
import com.eventapp.entities.Event;
import com.eventapp.dto.TicketCancelRequest;
import com.eventapp.dto.TicketCancelResponse;
import com.eventapp.service.EventService;
@RestController

@RequestMapping("api")
public class EventController {
	@Autowired
	private EventService eventService;
	public EventController(EventService eventService) 
	{
		this.eventService = eventService;
	}
	
	@GetMapping(path="event" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> getEvent(){
		List<Event> events=eventService.getAllEvents();
		//return books;
		//return new ResponseEntity<>(books,HttpStatus.OK);
		return ResponseEntity.ok(events);
		
	}

	@GetMapping(path="event/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public Event getAnEvent(@PathVariable(name = "id")int eventId){
		Event event=eventService.getEventById(eventId);
		return event;
		
	}
	//adding
	@PostMapping(path="event" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Event addEvent(@RequestBody Event event) {
		Event addedEvent=eventService.addEvent(event);
		return addedEvent;
	}
	
	//updating
	@PutMapping(path="event/{id}" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Event updateEvent(@PathVariable(name = "id")int eventId,@RequestBody Event event ) {
		Event updateEvent=eventService.updateEvent(eventId,event);
		return updateEvent;
	}
	@DeleteMapping(path="event/{id}" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Event deleteEvent(@PathVariable(name = "id")int eventId) {
		return eventService.deleteEvent(eventId);
	}
	
	@PostMapping(path="booking" ,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public TicketBookingResponse bookEvent(@RequestBody TicketBookingRequest eventRequest) {
		//Event addedEvent=eventService.addEvent(event);
		return eventService.bookTickets(eventRequest);
		
		
		
	}
	
	
	
	@PostMapping(path="cancel", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public TicketCancelResponse cancel( @RequestBody com.eventapp.dto.TicketCancelRequest cancelRequest) {
		
		return eventService.cancelTickets(cancelRequest);
	}
	 @GetMapping("events/{name}")
	  public ResponseEntity<Event> getEventByName(@PathVariable("name")String eventName)
	  { 
		  Event eventsByName=eventService.findByUserName(eventName); 
		  return new ResponseEntity<Event>(eventsByName,HttpStatus.OK); 
		  }
	 
	
}
