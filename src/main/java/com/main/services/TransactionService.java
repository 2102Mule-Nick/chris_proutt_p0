package com.main.services;

import com.main.pojo.Account;
import com.main.pojo.Transaction;

public interface TransactionService {

	void deposit(Account account, float amount) throws IllegalArgumentException;
	
	public void withdrawl(Account account, float amount);
	
	public float checkBalance(Account account);
}