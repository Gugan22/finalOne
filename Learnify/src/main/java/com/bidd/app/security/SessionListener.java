package com.bidd.app.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(30*60*1000);//30*60*1000
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		//System.out.println("session destroyed !");
	}
	
}
