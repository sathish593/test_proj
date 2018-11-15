package com.sathish.am.util;
//stand alone conn pooling
import java.sql.Connection;
import java.sql.SQLException;



import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil1 {

	private static BasicDataSource ds;
	static
	{
		try
		{
		ds= new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.driver");
		ds.setUrl("root");
		ds.setPassword("root");
		ds.setUrl("jdbc:mysql//localhost:3306/test");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			con=ds.getConnection();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
}
