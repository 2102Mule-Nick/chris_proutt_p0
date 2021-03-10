package com.main.utilies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class DatabaseConnection {
		
	Logger log = Logger.getRootLogger();

	public static String URL;

	public static String USERNAME;

	public static String PASSWORD;
	
	private static DatabaseConnection connectionFactory = null;

	private DatabaseConnection() {
		URL = "jdbc:postgresql://" + System.getenv("BANK_DB_URL") + ":5432/" + "bankapp" + "?";

		USERNAME = System.getenv("BANK_DB_USERNAME");

		PASSWORD = System.getenv("BANK_DB_PASSWORD");
	}
	
	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		log.info("URL : " + URL);

		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			log.error("Failed to connect to DB", e);
		}
		return null;
	}
	
	public static synchronized Connection getConnection() {
		
		if (connectionFactory == null) {
			connectionFactory = new DatabaseConnection();
		}

		return connectionFactory.createConnection();

	}

}	