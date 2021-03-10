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

public class TransactionDaoImpl implements TransactionDao {

	Logger log = Logger.getRootLogger();
	
	private Connection conn;
	
	public TransactionDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTransation(Account account, Transaction transaction) {
		// Connect to the database
		String sql = "insert into transaction (user_id, account_id, transaction_type, amount, opening_balance)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, "select user_id from users where username = " + "'" + account.getUsername() + "'");
			pstmt.setString(2, "select account_id from accounts where username = " + "'" + account.getUsername() + "'");
			pstmt.setString(3, transaction.getType());
			pstmt.setFloat(4, transaction.getAmount());
			pstmt.setFloat(5, account.getBalance());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			
		} catch (SQLException e) {
			Log.error("Couldn't connect to the database");
		}
	}

	@Override
	public Transaction getTransaction(Account account) {
		// Create Sql query
		String sql = "select * from transactions where user_id = (select * from users where username = " + "'" + account.getUsername() + "'" + ")";
		// Connect to the database
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
	public void deleteTransaction(Account account) {
		// Connect to the database
		
		// Create Sql query
				
		// Send prepared statement  to data base
				
		// return Transaction

	}

	@Override
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
