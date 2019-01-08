package com.cg.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection()throws IOException, ClassNotFoundException, SQLException  {

		Properties properties = new Properties();

	
		FileInputStream inputStream = new FileInputStream("resources/DB.properties");
		
			properties.load(inputStream);

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

		
				Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			return con;

	}
}
