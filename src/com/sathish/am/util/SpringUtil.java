package com.sathish.am.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext context=null;
	static
	{
		context= new ClassPathXmlApplicationContext("spring-context.xml");
	}

	public static ApplicationContext getContext()
	{
		return context;
	}
}
