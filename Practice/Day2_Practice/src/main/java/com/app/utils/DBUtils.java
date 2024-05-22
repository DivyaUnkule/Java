package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	private static Connection connection;
	private static final String URL;
	private static final String username;
	private static final String password;
	static {
		URL = "jdbc:mysql://localhost:3306/iacsd_mar24";
		username = "root";
		password = "12345";
	}

	public static Connection openConnection() throws SQLException
	{
		connection = DriverManager.getConnection(URL,username,password);
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
