package com.bidd.app.util;

import java.util.UUID;

public class Calculus {

	
	public String getRandomNumber()
	{
		String random_num=UUID.randomUUID().toString().replaceAll("-", ""); 
		return random_num;
	}
	
	
}
