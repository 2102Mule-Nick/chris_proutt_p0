package com.main.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public class AccountDaoPostres implements AccountDao {

	String url = "jdbc:postgresql://localhost/test";
	Properties props = new Properties();
	props.setProperty("user","fred");
	props.setProperty("password","secret");
	props.setProperty("ssl","true");
	Connection conn = DriverManager.getConnection(url, props);
	
	public AccountDaoPostres() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createAccount(Account account) throws UsernameTaken {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Account> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountbyUsername(String username) throws AccountNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAccount(Account account) {
		// TODO Auto-generated method stub

	}

}
