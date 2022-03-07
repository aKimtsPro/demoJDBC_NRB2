package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String URL = "jdbc:mysql://localhost:3306/dbslide"; 
	private static String USER = "root";
	private static String PSWD = "root";
	
	static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PSWD);
	}
	
}
