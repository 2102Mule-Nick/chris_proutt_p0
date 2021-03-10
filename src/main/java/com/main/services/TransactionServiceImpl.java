package com.main.services;

import org.apache.log4j.Logger;

import com.main.dao.AccountDao;
import com.main.dao.TransactionDao;
import com.main.pojo.Account;
import com.main.pojo.Transaction;

public class TransactionServiceImpl implements TransactionService {
	
	Logger log = Logger.getRootLogger();
	
	private AccountDao accountDao;
	private Transaction trans;
	private TransactionDao transactions;
	
	public TransactionServiceImpl(AccountDao accountdao) {
		this.accountDao = accountdao;
	}

	@Override
	public void deposit(Account account, float amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		float temp;
		if (amount > 0) {
			temp = account.getBalance() + amount;
			account.setBalance(temp);
			accountDao.updateUser(account);
			trans.setAmount(temp);
			trans.setType("deposit");
			transactions.createTransation(account, trans);
			System.out.println("You have deposited $" + amount);
			System.out.println("Your current balance is: \n" + account.getBalance() + "\n");
		}
		else {
			log.error("Amount is invalid");
			throw new IllegalArgumentException(); // needs to be more detailed exception in the future
		}
		
	}

	@Override
	public void withdrawl(Account account, float amount) {

		float temp = 0;
		
		if ((amount > 0) && (amount < account.getBalance())) {
			temp = account.getBalance() - amount;
			
			
			account.setBalance(temp);
			accountDao.updateUser(account);
			trans.setAmount(temp);
			trans.setType("deposit");
			transactions.createTransation(account, trans);
			System.out.println("Your balance is now: \n" + account.getBalance() + "\n");
		}
		else {
			log.error("Overdraw attempt!");
			throw new IllegalArgumentException(); // needs to be more detailed exception in the future
		}
		
	}

	@Override
	public float checkBalance(Account account) {
		return accountDao.getAccountBalance(account);
	}

}
