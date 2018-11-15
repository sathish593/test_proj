package com.sathish.am.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sathish.am.dao.AssetDAO;
import com.sathish.am.pojo.UserPojo;

public class Test {
	@Autowired
	private static AssetDAO dao;
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("Spring-servlet.xml") ;
	UserPojo pojo=new UserPojo();
	pojo.setPassword("sathish");
	pojo.setPassword("sathish");
		dao.Login(pojo);
	}

}
