package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	/*
	 * private static Connection connection; private static final String URL;
	 * private static final String USERNAME; private static final String PASSWORD;
	 */
	
	/*
	 * static { URL="JDBC:mysql://localhost:3306/iacsd_mar24"; USERNAME="root";
	 * PASSWORD="12345"; }
	 */
	public static void openConnection(String DB_URL,String USERNAME,String PASSWORD) throws SQLException
	{
		connection=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
	 public static Connection getConnection()throws SQLException { 
		 return connection;
	 }
	 
	
	public static void closeConnection() throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
	}

}
