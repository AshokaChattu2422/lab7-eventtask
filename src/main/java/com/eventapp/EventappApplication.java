package com.eventapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eventapp.entities.Event;
import com.eventapp.entities.User;
import com.eventapp.service.EventService;
import com.eventapp.service.UserService;

@SpringBootApplication
public class EventappApplication implements CommandLineRunner{
	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;
	public static void main(String[] args) 
	{
		SpringApplication.run(EventappApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		
		//User user =new User("Ashoka","ashoka","ROLE_ADMIN");
		//User user2 =new User("chattu","chattu123","ROLE_ClERK");
		
	//userService.addUser(user);
	//userService.addUser(user2);
		
//		Event e1=new Event("Marriage", "Tpt", 30000.00, "2020-010-12", 50, 500);
//		Event e2=new Event("Bdy", "Chennai", 50000.00, "2020-05-12", 10, 300);
//		Event e3=new Event("special", "Nellore", 70000.00, "2020-05-12", 15, 700);
//		Event e4=new Event("Normal", "Slpt", 30000.00, "2020-05-12", 27, 100);
//		
//		eventService.addEvent(e1);
//		eventService.addEvent(e2);
//		eventService.addEvent(e3);
//		eventService.addEvent(e4);
//		
//		
	}
	
	//List<Event> events=eventService.getAllEventUsers();
			//events.forEach(event-> System.out.println(event));
}
