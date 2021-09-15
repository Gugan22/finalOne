package com.bidd.app.util;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class SessionUtil {

	public String getSessionValue(String attributeName) throws Exception
	{
		String attributeValue=null;
		try
		{		
			//check the attribute value available in session or not
			if(RequestContextHolder.currentRequestAttributes().getAttribute(attributeName,RequestAttributes.SCOPE_SESSION) == null)
			{			
				throw new UsernameNotFoundException("Login failed. Please try again");
			}
			//if it is available then return the value
			attributeValue=RequestContextHolder.currentRequestAttributes().getAttribute(attributeName,RequestAttributes.SCOPE_SESSION).toString();
			return attributeValue;
		}
	 
		catch(Exception ex)
		{
			String message ="  AttributeName: "+attributeName+"  Exception: "+ex ;
			throw ex;
		}
	}
	
}
