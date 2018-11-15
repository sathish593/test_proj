package com.sathish.am.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;




public class HtemplateDemo {

	public HtemplateDemo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public static void main(String[] args) {
			
		
		//ApplicationContext context= new ClassPathXmlApplicationContext("spring-context2.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		TestDao tdao=(TestDao) context.getBean(TestDao.class);
		tdao.insert(); 
		tdao.test();
		
	}
}
