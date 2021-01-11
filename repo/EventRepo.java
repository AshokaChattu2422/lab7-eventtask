package com.eventapp.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.entities.Event;


  @Repository 
  public interface EventRepo extends JpaRepository<Event,Integer> 
  {

	Event findByUserName(String userName);

	List<Event> findByEventDateBetween(LocalDate date1, LocalDate date2);
  		
  }
 