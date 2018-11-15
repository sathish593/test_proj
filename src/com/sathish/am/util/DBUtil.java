package com.sathish.am.util;
//server based conn pool
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	private static DataSource ds;
	static
	{
		try
		{
		InitialContext ctx = new InitialContext();
		 ds = (DataSource)ctx.lookup("java:comp/env/jdbc/asset");
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
