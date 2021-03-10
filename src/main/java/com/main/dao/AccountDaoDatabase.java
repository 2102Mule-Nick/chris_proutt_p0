package com.main.dao;

import org.apache.log4j.Logger;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;
import com.main.utilies.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDaoDatabase implements AccountDao {
	
	Logger log = Logger.getRootLogger();
	
	private Connection conn;

	@Override
	public void createAccount(Account account) throws UsernameTaken {
		
		log.trace("User Creation method called");
		
		conn = DatabaseConnection.getConnection();
		
		String sql = "insert into users (first_name, last_name, username, pword) values ('" + account.getFirstName() + "', '" + account.getLastName() + "', '" + account.getUsername() + "', '" + account.getPassword() + "')";
		
		Statement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.execute(sql);
			conn.close();
			log.info("User successfully created");
		} catch (SQLException e) {
			log.error("User was not created");
			e.printStackTrace();
		}
	}

	@Override
	public Account getAccountbyUsername(String username) throws AccountNotFound {
		Account account = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}
		
		//log.info("User Search Method Called");
		
		conn = DatabaseConnection.getConnection();
		
		String sql = "select username from users where username = '" + username + "'";
		
		try {
			Statement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				log.info("User found in the database");
				account = new Account();
				account.setFirstName(rs.getString("first_name"));
				account.setLastName(rs.getString("last_name"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("pword"));
			}
					
		} catch (SQLException e) {
			log.error("Failed to connect to database");
		}
		
		
		return account;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}


}
