/**
 * 
 */
package com.main.services;

import org.apache.log4j.Logger;

import com.main.dao.AccountDao;
import com.main.exceptions.AccountNotFound;
import com.main.exceptions.InvalidPassword;
import com.main.exceptions.UserNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public class AuthServiceImpl implements AuthService {
	
	Logger log = Logger.getRootLogger();
	
	private AccountDao accountDao;
	
	public AuthServiceImpl(AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}

	@Override
	public boolean existingUser(Account account) {
		try {
			if (accountDao.getAccountbyUsername(account.getUsername()) != null) {
				return true;
			}
		} catch (AccountNotFound e1) {
			return false;
		}
		return false;
	}

	@Override
	public Account authenticateUser(Account account) throws InvalidPassword, UserNotFound, AccountNotFound {
		Account existingUser = accountDao.getAccountbyUsername(account.getUsername());
		
		if (existingUser.getPassword().equals(account.getPassword())) {
			accountDao.getAccountBalance(existingUser);
			return existingUser;
		}

		throw new InvalidPassword();
	}

	@Override
	public Account registerUser(Account account) throws UsernameTaken {
		accountDao.createAccount(account);
		accountDao.createBankAccount(account);
		log.info("User registered");
		return account;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
