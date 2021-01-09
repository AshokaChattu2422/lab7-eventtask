package com.eventapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name="event_table")
public class Event {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="event_name",nullable=false,length=50)	
	private String name;
	
	@Column(name="event_location",nullable=false,length=50)	
	private String location;
	
	@Column(name="event_price",nullable=false,length=50)	
	private Double price;	
	
	@Column(name="event_date",nullable=false,length=50)
	private String date;	
	
	@Column(name="event_discount",nullable=false,length=50)
	private Integer discount;
	
	@Column(name="event_noOfTicket",nullable=false,length=50)
	private Integer noOfTicket;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(Integer noOfTicket) {
		this.noOfTicket = noOfTicket;
	}

	public Event() {
	}

	public Event(String name, String location, Double price, String date, Integer discount, Integer noOfTicket) {
		super();
		this.name = name;
		this.location = location;
		this.price = price;
		this.date = date;
		this.discount = discount;
		this.noOfTicket = noOfTicket;
	}

	public List<GrantedAuthority> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}	
}