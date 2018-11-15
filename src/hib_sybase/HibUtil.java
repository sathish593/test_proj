package hib_sybase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class HibUtil {

	private static Configuration conf;
	private static SessionFactory sf;
	static
	{
	 conf=new AnnotationConfiguration().configure("hibernate.cfg.xml");
	 sf=conf.buildSessionFactory();
		
	}
	public static Session getSession()
	{
		
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

	public static void main(String[] args) {
		Session ses =getSession();
		if(ses!=null)
		{
			System.out.println("success");
		}
	}
	}
	

