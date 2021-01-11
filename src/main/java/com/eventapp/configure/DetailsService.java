package com.eventapp.configure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eventapp.service.UserService;
@Service
public class DetailsService implements UserDetailsService{
	

	@Autowired
	private UserService userService;
	public DetailsService(UserService userService) {
		this.userService = userService;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	com.eventapp.entities.User user=userService.findByusername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("user with name :"+ username +" is not found");
		//I need to convert my appuser to spring sec user
	
		//i need to convert ArraryList to String[]
		User secUser=new User(user.getUsername(),user.getPassword(),AuthorityUtils.createAuthorityList(new String[] {user.getRoles()}));
		
		return secUser;
	}

}
