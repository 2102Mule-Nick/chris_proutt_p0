package com.main.dao;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;
import com.main.pojo.Transaction;

public interface AccountDao {
	
	public void createAccount(Account account) throws UsernameTaken;
	
	public void createBankAccount(Account account);
		
	public Account getAccountbyUsername(String username) throws AccountNotFound;

	public void updateUser(Account account);
	
	public float getAccountBalance(Account account);

	void updateAccountBalance(Transaction transaction, Account account);
}
