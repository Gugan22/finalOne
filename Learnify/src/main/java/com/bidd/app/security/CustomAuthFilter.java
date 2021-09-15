package com.bidd.app.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.RequestContextHolder;

import com.bidd.app.enitity.UserMaster;
import com.bidd.app.repository.UserMasterDao;
import com.bidd.app.util.ControllerUtil;


public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter{

	
	private final AuthenticationManager authenticationManager;

	public CustomAuthFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException {
		//get user name and password from login request. the login request content type in form data
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						username,
						password,
						new ArrayList<>())
				);
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		try {
			String userName = req.getParameter("username"); 
			//get the current session id
			String session_id = RequestContextHolder.currentRequestAttributes().getSessionId();
			res.addHeader("session_id", session_id);
			//save the current session id in session config table
			UserMasterDao userDao = ApplicationContexUtil.getAppContext().getBean(UserMasterDao.class);
			
			//prepare response to send session id
			ControllerUtil controllerUtil = new ControllerUtil();
			JSONObject json = new JSONObject();
			json.put("session_id",session_id);
			String resString = controllerUtil.getSuccessResponse(json.toString(), "Login Successful", null, userName, "login");
			res.getOutputStream()
			.println(resString);

			//			String n= auth.getName();
			//			String r= auth.getAuthorities().toString();
			//System.out.println("role"+ n+r);
			//save login count information in dynamo db
			List<UserMaster> users = userDao.findById(userName);
			UserMaster  user = new UserMaster();
			if(users != null)
			{
				user = users.get(0);
			}
			
			user.setSessionId(session_id);
			userDao.save(user);
			
			String branch_id = "HeadQuarters";
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}  

}
