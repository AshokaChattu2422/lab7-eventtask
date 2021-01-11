package com.eventapp.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventapp.dto.TicketBookingRequest;
import com.eventapp.dto.TicketBookingResponse;
import com.eventapp.dto.TicketCancelRequest;
import com.eventapp.dto.TicketCancelResponse;
import com.eventapp.entities.Event;
import com.eventapp.repo.EventRepo;
import com.eventapp.service.exceptions.EventNotFoundException;


@Service
@Transactional
public class EventServiceImpl implements EventService{

	private EventRepo eventRepo;
	
	@Autowired
	public EventServiceImpl(EventRepo eventRepo) {
		this.eventRepo=eventRepo;
		
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public Event getEventById(int eventId) {
		return eventRepo.findById(eventId).orElseThrow(()->new EventNotFoundException("product with id:"+eventId+"not found"));
	}

	@Override
	public Event addEvent(Event event) {
		eventRepo.save(event);
		return event;
	}
  //For Update
	@Override
	public Event updateEvent(int eventId, Event event) {
		Event eventToUpdate=getEventById(eventId);
		eventToUpdate.setPrice(event.getPrice());
		eventToUpdate.setDiscount(event.getDiscount());
		eventRepo.save(eventToUpdate);
		return eventToUpdate;
	}
	// For Delete

	@Override
	public Event deleteEvent(int eventId) {
		Event eventToDelete=getEventById(eventId);
		eventRepo.delete(eventToDelete);
		return eventToDelete;
	}

	@Override
	public Event findByUserName(String userName) {
		return eventRepo.findByUserName(userName);
		 
	}

	@Override
	public List<Event> findByEventDateBetween(LocalDate date1 ,LocalDate date2) {
		// TODO Auto-generated method stub
		 return eventRepo.findByEventDateBetween(date1,date2);
	}

	
	


	@Override
	public TicketBookingResponse bookTickets(TicketBookingRequest request) {
		TicketBookingResponse response=new TicketBookingResponse();
		Event eventToBook=findByEventId(request.getEventid());
		if(eventToBook==null) {
			throw new EventNotFoundException("event with id :" +request.getEventid()+  "is not found");
		}
		if(request.getNoOftickets()>eventToBook.getNoOfTicket()) {
			response.setMessage("no of ticket requested is more then what we book");
			response.setAmountpayable(0.0);
		}else {
			eventToBook.setNoOfTicket(eventToBook.getNoOfTicket()-request.getNoOftickets());
			this.updateEvent(eventToBook.getId(), eventToBook);
			response.setMessage("ticket book successfully");
			response.setAmountpayable(eventToBook.getPrice()*request.getNoOftickets());
		}
		
		
		return response;
	}
	
	
	


	
	//@Override
	@Override
	public TicketCancelResponse cancelTickets(TicketCancelRequest request) {
		TicketCancelRequest response=new TicketCancelRequest();
		Event eventTicketToCancel=findByEventId(request.getEventid());
		if(eventTicketToCancel==null) {
			throw new EventNotFoundException("event with id :" +request.getEventid()+  "is not found");
		}
		LocalDate eventDate=eventTicketToCancel.getEventDate();
		if(eventDate.isBefore(LocalDate.now())) {
			
		}
		eventTicketToCancel.setNoOfTicket(eventTicketToCancel.getNoOfTicket()+request.getNoOfTickets());
		//return 50% of booking amnt
		double amountReturned=((eventTicketToCancel.getPrice()*eventTicketToCancel.getNoOfTicket()*
				(100 - eventTicketToCancel.getDiscount())/100)*0.5);
		TicketCancelResponse cancelResponse=new TicketCancelResponse();
		cancelResponse.setAmountReturned(amountReturned);
		cancelResponse.setMessage("tickets are cancelled");
		return cancelResponse;
	}
	

	@Override
	public TicketCancelResponse bookTickets(TicketCancelRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	private Event findByEventId(int eventid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}