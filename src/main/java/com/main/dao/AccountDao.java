package com.main.dao;

import java.util.List;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public interface AccountDao {
	
	public void createAccount(Account account) throws UsernameTaken;
		
	public Account getAccountbyUsername(String username) throws AccountNotFound;

	public void updateUser(Account account);
	
	public float getAccountBalance(Account account);
	
}
