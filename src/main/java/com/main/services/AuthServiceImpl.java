/**
 * 
 */
package com.main.services;

import com.main.dao.AccountDao;
import com.main.exceptions.AccountNotFound;
import com.main.exceptions.InvalidPassword;
import com.main.exceptions.UserNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

/**
 * @author Proutt
 *
 */
public class AuthServiceImpl implements AuthService {
	
	private AccountDao accountDao;
	
	/**
	 * @param accountDao 
	 * 
	 */
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
			return existingUser;
		}

		throw new InvalidPassword();
	}

	@Override
	public Account registerUser(Account account) throws UsernameTaken {
		accountDao.createAccount(account);
		return account;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
