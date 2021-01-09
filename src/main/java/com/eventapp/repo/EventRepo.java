package com.eventapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.entities.Event;


  @Repository 
  public interface EventRepo extends JpaRepository<Event,Integer> 
  {
  		
  }
 