package com.eventapp.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eventapp.entities.User;
import com.eventapp.repo.UserRepo;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepo userRepo;
	

	public UserRepo getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		
	}

	@Override
	public User findByusername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByusername(username);
	}

}
