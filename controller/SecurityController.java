package com.eventapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@RequestMapping("home")
	public String hello()
	{
		return "hello home";
	}
	@RequestMapping("admin")
	public String admin()
	{
		return "hello admin";
	}
	@RequestMapping("mgr")
	public String mgr()
	{
		return "hello mgr";
	}
	@RequestMapping("user")
	public String emp()
	{
		return "hello user";
	}
	

}
