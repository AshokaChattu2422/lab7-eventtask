package com.eventapp.service;

import com.eventapp.entities.User;

public interface UserService {
	public void addUser(User user);
	public User findByusername(String username);

}
