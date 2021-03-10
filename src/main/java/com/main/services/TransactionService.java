package com.main.services;

import javax.transaction.InvalidTransactionException;

import com.main.pojo.Account;
import com.main.pojo.Transaction;

public interface TransactionService {

	public void deposit(Account account, float amount) throws InvalidTransactionException;
	
	public void withdrawl(Account account, float amount) throws InvalidTransactionException;
	
	public float checkBalance(Account account);
}