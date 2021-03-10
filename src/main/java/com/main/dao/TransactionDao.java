/**
 * 
 */
package com.main.dao;

import java.sql.Connection;

import com.main.pojo.Account;
import com.main.pojo.Transaction;

public interface TransactionDao {
	
	public void createTransation(Account account, Transaction transaction);
	
	public Transaction getTransaction(Account account);
	
	public void deleteTransaction(Account account);

	public void setConn(Connection conn);
}
