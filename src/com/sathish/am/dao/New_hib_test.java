package com.sathish.am.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.sathish.am.pojo.AssetPojo;
import com.sathish.am.pojo.Employeepojo;

public class New_hib_test {

	public New_hib_test() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		Configuration conf=new AnnotationConfiguration().configure("hibernate.cfg.xml");
		SessionFactory sf=conf.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		Query query=ses.createQuery("from Employeepojo");
		List<Employeepojo> list=(List<Employeepojo>) query.list();
		for (Employeepojo ep : list) {
			System.out.println(ep.getId()+"::"+ep.getName()+"::"+ep.getSsn());
		
		}
		tx.commit();
		ses.close();
	}
}
