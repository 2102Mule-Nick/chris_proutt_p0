package com.main.services;

import javax.transaction.InvalidTransactionException;

import org.apache.log4j.Logger;

import com.main.dao.AccountDao;
import com.main.dao.TransactionDao;
import com.main.dao.TransactionDaoImpl;
import com.main.pojo.Account;
import com.main.pojo.Transaction;

public class TransactionServiceImpl implements TransactionService {
	
	Logger log = Logger.getRootLogger();
	
	private AccountDao accountDao;
	private TransactionDao transactions;
	
	public TransactionServiceImpl(AccountDao accountdao, TransactionDao transactions) {
		this.accountDao = accountdao;
		this.transactions = transactions;
	}

	@Override
	public void deposit(Account account, float amount) throws InvalidTransactionException {
		// TODO Auto-generated method stub
		float temp;
		if (amount > 0) {
			temp = account.getBalance() + amount;
			account.setBalance(temp);
			
			//new transaction
			Transaction transaction = new Transaction();
			transaction.setType("deposit");
			transaction.setAmount(amount);
			transaction.setOpening_balance(account.getBalance());
			transaction.setClosing_balance(temp);
			transactions.createTransation(account, transaction);
			
			accountDao.updateUser(account);
			accountDao.updateAccountBalance(transaction, account);
			System.out.println("You have deposited $" + amount);
			System.out.println("Your current balance is: \n" + account.getBalance() + "\n");
		}
		else {
			log.error("Amount is invalid");
			throw new InvalidTransactionException(); // needs to be more detailed exception in the future
		}
		
	}

	@Override
	public void withdrawl(Account account, float amount) throws InvalidTransactionException {

		float temp = 0;
		
		if ((amount > 0) && (amount < account.getBalance())) {
			temp = account.getBalance() - amount;
			account.setBalance(temp);
			
			//new transaction
			Transaction transaction = new Transaction();
			transaction.setType("withdrawl");
			transaction.setOpening_balance(amount);
			transaction.setClosing_balance(temp);
			transactions.createTransation(account, transaction);
			
			accountDao.updateUser(account);
			accountDao.updateAccountBalance(transaction, account);
			System.out.println("Your balance is now: \n" + account.getBalance() + "\n");
		}
		else {
			log.error("Overdraw attempt!");
			throw new InvalidTransactionException();
		}
		
	}

	@Override
	public float checkBalance(Account account) {
		return accountDao.getAccountBalance(account);
	}

}
