package com.eventapp.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eventapp.service.EventService;
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyAuthEntryPoint myAuthEntryPoint;
	
	@Autowired
	private EventService eventService;
	
	//auth
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(eventService);
		
	auth.inMemoryAuthentication()
		.withUser("ashu").password("ashu").roles("ADMIN")
		.and()
		.withUser("pooja").password("pooja123").roles("MGR")
		.and()
		.withUser("chattu").password("chattu").roles("USR");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/user/**").hasAnyRole("USR","ADMIN","MGR")
		.antMatchers("/home/**").permitAll()
		.and().httpBasic()
		.authenticationEntryPoint(myAuthEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
}