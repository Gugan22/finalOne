package com.bidd.app.security;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.bidd.app.enitity.BatchAssignment;
import com.bidd.app.enitity.UserMaster;
import com.bidd.app.repository.BatchAssignmentDao;
import com.bidd.app.repository.UserMasterDao;



public class CustomAuthProvider implements AuthenticationProvider {
	
	@Autowired 
	UserMasterDao userDao;
	
	@Autowired
	BatchAssignmentDao batchDao;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login_id = authentication.getName();
		String password = authentication.getCredentials().toString();
		try {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			UserMaster user = null;

			String email = login_id;
			// For Support
			//first we need to check the login id is support user or not
			
				//if it is not support user then check the user master table
				List<UserMaster> users = userDao.findById(email);//first check the email service
				
				
				if(users != null)
				{
					//check the phone number based service
					user = users.get(0);
				}

				if(user!=null)
				{
					
					authorities.add(new SimpleGrantedAuthority(user.getRole()));
					
					RequestContextHolder.getRequestAttributes().setAttribute("User",user.getId(),RequestAttributes.SCOPE_SESSION);
					
					List<BatchAssignment> batches = batchDao.findByUserId(user.getId());
					
					if(batches!=null) {
						RequestContextHolder.getRequestAttributes().setAttribute("Batch",batches.get(0).getBatchId(),RequestAttributes.SCOPE_SESSION);
						RequestContextHolder.getRequestAttributes().setAttribute("Team", user.getId(),RequestAttributes.SCOPE_SESSION);
						
					}
					
					RequestContextHolder.getRequestAttributes().setAttribute(email, users, 0);
					if(!BCrypt.checkpw(password,user.getPassword()))       //Decrypting the Password and check
					{
						throw new UsernameNotFoundException("Your Credentials is Wrong");
					}
					else
					{
								//set username password authentication for future service reference
						return new UsernamePasswordAuthenticationToken(login_id, password,authorities);
					}
				}
				else//if the user not present then throw this error
				{
					throw new UsernameNotFoundException("This user don't have account !");
				}
			
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return null;
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
