package com.main.services;

import com.main.pojo.Account;
import com.main.pojo.Transaction;

public interface TransactionService {
	public void createTransaction(Account account, Transaction newTrans);
	
	public void updatebalance(Account account);
	
	public Transaction getTransaction(Account account);
	
	public void deleteTransaction(Account account);
}