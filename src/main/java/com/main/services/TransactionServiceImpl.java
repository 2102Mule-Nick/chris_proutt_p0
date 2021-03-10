package com.main.services;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.main.dao.AccountDao;
import com.main.pojo.Account;
import com.main.pojo.Transaction;
import com.main.utilies.DatabaseConnection;

public class TransactionServiceImpl implements TransactionService {
	
	Logger log = Logger.getRootLogger();
	
	Transaction transaction;
	private AccountDao accountDao;
	
	public TransactionServiceImpl(AccountDao accountdao) {
		this.accountDao = accountdao;
	}

	@Override
	public void createTransaction(Account account, Transaction newTrans) {
		
		
	}
	
	@Override
	public void updatebalance(Account account) {
		Transaction transaction = new Transaction();
		
		log.trace("User Creation method called");
		
		Connection conn = DatabaseConnection.getConnection();
		
		String sql = "update * from accounts where ";
	}

	@Override
	public Transaction getTransaction(Account account) {
		Transaction transaction = new Transaction();
		
		log.trace("User Creation method called");
		
		Connection conn = DatabaseConnection.getConnection();
		
		String sql = "select * from accounts where ";
		
		return null;
	}

	@Override
	public void deleteTransaction(Account account) {
		// TODO Auto-generated method stub

	}

}
