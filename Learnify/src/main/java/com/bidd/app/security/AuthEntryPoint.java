package com.bidd.app.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthEntryPoint implements AuthenticationEntryPoint{
	
	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
		//System.out.println("RestAuthenticationEntryPoint ");
		String username = request.getParameter("username");
		String message ="Username: " +username +"  Exception: Rest authentication entry point -unauthorized "; 
		
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized");
	}
	
	
}
