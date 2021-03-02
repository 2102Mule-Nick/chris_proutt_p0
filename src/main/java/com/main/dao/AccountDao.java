package com.main.dao;

import java.util.List;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public interface AccountDao {
	
	public boolean createAccount(Account account) throws UsernameTaken;
	
	public List<Account> getAllUsers();
	
	public Account getAccountbyUsername(String username) throws AccountNotFound;
	
	public void updateAccount(Account account);
	
	public void removeAccount(Account account);
}
