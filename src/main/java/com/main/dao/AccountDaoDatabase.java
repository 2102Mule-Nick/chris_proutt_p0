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

public class AccountDaoDatabase implements AccountDao {
	
	Logger log = Logger.getRootLogger();
	
	private Connection conn;

	@Override
	public void createAccount(Account account) throws UsernameTaken {
		
		log.trace("User Creation method called");
		
		conn = DatabaseConnection.getConnection();
		
		String sql = "insert into users (first_name, last_name, username, pword) values (?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getFirstName());
			pstmt.setString(2, account.getLastName());
			pstmt.setString(3, account.getUsername());
			pstmt.setString(4, account.getPassword());
			pstmt.executeUpdate();
			log.info("User successfully created");
		} catch (SQLException e) {
			log.error("User was not created");
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
		
		log.info("User Search Method Called");
		
		conn = DatabaseConnection.getConnection();
		
		String sql = "select * from users where username = ?";
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				log.info("User found in the database");
				account = new Account();
				account.setFirstName(rs.getString("first_name"));
				account.setLastName(rs.getString("last_name"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("pword"));
				return account;
			}
					
		} catch (SQLException e) {
			log.error("Failed to connect to database");
		}
		
		
		return null;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void updateUser(Account account) {
		conn = DatabaseConnection.getConnection();
		
		String sql = "UPDATE accounts set balance = ? WHERE account_id = (select user_id from users where username = ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setFloat(1, account.getBalance());
			pstmt.setString(2, account.getUsername());
			
			pstmt.executeUpdate();
			log.info("Update Successful");
		} catch (SQLException e) {
			log.error("Balance update Error");
		}
		
	}

	@Override
	public float getAccountBalance(Account account) {
		conn = DatabaseConnection.getConnection();
		
		String sql = "select balance from accounts where user_id = (select user_id from users where username = ?)";
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getUsername() );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				log.info("User found in the database");
				account = new Account();
				account.setBalance(rs.getFloat(1));
				return account.getBalance();
			}
		} catch(SQLException e) {
			log.error("Balance update Error");
		}
		return 0;
	}
}