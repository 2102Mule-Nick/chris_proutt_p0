package com.main.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public class AccountDaoImpl implements AccountDao {
	
	private ArrayList<Account> accountList;

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	public AccountDaoImpl() {
		accountList = new ArrayList<Account>();
	}
	
	@Override
	public void createAccount(Account account) throws UsernameTaken {
		//make sure actually not blank input
				if(account.getUsername() != null && account.getPassword() != null ) {
					Iterator<Account> iter = accountList.iterator();
				
				// Make sure account not taken
					while(iter.hasNext()) {
						if(iter.next().getUsername().equals(account.getUsername())) {
							System.out.println("Username is already taken.");
							throw new UsernameTaken();
						}
					}
				//if input good add user to list	
					accountList.add(account);
				}		
	}

	@Override
	public List<Account> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountbyUsername(String username) throws AccountNotFound {
		Iterator<Account> iter = accountList.iterator();
		
		while(iter.hasNext()) {
			
			Account existingAccount = iter.next();
			if(existingAccount.getUsername().equals(username)) {
				return existingAccount;
			}
		}
		
		throw new AccountNotFound();
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
