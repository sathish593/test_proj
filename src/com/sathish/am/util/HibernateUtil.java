package com.sathish.am.util;

//import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration conf;
	private static SessionFactory sf;
	static
	{
	 conf=new AnnotationConfiguration().configure("hibernate.cfg.xml");
	 sf=conf.buildSessionFactory();
		
	}
	public static Session getSession()
	{
		System.out.print("in get session");
		Session ses=null;	
		try
		{
		 ses=sf.openSession();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ses;
		
	}

}
