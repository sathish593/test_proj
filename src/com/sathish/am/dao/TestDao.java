package com.sathish.am.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sathish.am.pojo.Employeepojo;



@Configuration
@ImportResource("classpath:/spring-context2.xml")
public class TestDao {
	@Autowired
	HibernateTemplate htemplate;
	
	public void test() {

		
		System.out.println(htemplate);
		List<Employeepojo> list=(List<Employeepojo>)htemplate.find("from Employeepojo");
		for (Employeepojo ep : list) {
			System.out.println(ep.getId()+"::"+ep.getName()+"::"+ep.getSsn());
		
		}
		
	}
	
	public void insert() {
		Employeepojo po=new Employeepojo();
		po.setId(10);
		po.setName("abcd");
		po.setSsn("12974397");
		htemplate.save(po);
	}
	
	
	

}
