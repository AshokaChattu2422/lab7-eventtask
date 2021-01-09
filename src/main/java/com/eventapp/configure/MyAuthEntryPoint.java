package com.eventapp.configure;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Service;
@Service
public class MyAuthEntryPoint extends BasicAuthenticationEntryPoint{

	@Override
	public void afterPropertiesSet() {
		setRealmName("hcl-app");
		super.afterPropertiesSet();
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setHeader("WWW-Authenticate", "auth error:"+getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter out=response.getWriter();
		out.print("401-authentication failed, HCL");
	}

}
