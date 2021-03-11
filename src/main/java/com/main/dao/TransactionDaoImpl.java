package com.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.esotericsoftware.minlog.Log;
import com.main.pojo.Account;
import com.main.pojo.Transaction;
import com.main.utilies.DatabaseConnection;

public class TransactionDaoImpl implements TransactionDao {

	Logger log = Logger.getRootLogger();
	
	private Connection conn;
	
	public TransactionDaoImpl() {
	}

	@Override
	public void createTransation(Account account, Transaction transaction) {
		log.trace("User Creation method called");
		
		// Connect to the database
		String sql = "insert into transactions (user_id, account_id, transaction_type, amount, opening_balance, ending_balance) values ((select user_id from users where username = ?), (select account_id from accounts where user_id = (select user_id from users where username = ?)),?, ?, ?, ?)";
		
		conn = DatabaseConnection.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getUsername());
			pstmt.setString(3, transaction.getType());
			pstmt.setFloat(4, transaction.getAmount());
			pstmt.setFloat(5, transaction.getOpening_balance());
			pstmt.setFloat(6, transaction.getClosing_balance());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			Log.error("Couldn't connect to the database");
		}
	}

	@Override
	public Transaction getTransaction(Account account) {
		// Create Sql query
		String sql = "select top * from transactions where user_id = (select * from users where username = ?)";
		// Connect to the database
		
		conn = DatabaseConnection.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		// Send prepared statement  to data base
		
		// return Transaction
		
		return null;
	}

	@Override
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
