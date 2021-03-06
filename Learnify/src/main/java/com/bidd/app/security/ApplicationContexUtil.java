package com.bidd.app.security;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContexUtil implements ApplicationContextAware{

	
	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}
	

	public static ApplicationContext getAppContext() {
		return ctx;
	}
	
	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}
	
	
}
