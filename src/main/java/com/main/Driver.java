package com.main;

import java.util.Scanner;

import com.main.dao.AccountDao;
import com.main.dao.AccountDaoDatabase;
import com.main.dao.TransactionDao;
import com.main.dao.TransactionDaoImpl;
import com.main.pojo.Account;
import com.main.services.AuthService;
import com.main.services.AuthServiceImpl;
import com.main.services.TransactionService;
import com.main.services.TransactionServiceImpl;
import com.main.ui.CheckingAccountMenu;
import com.main.ui.LoginMenuUi;
import com.main.ui.Menu;
import com.main.ui.RegistrationMenu;
import com.main.ui.WelcomeMenu;

public class Driver {
	
	public static Scanner scan = new Scanner(System.in);
	public static Account account = new Account();
	
	public static void main(String[] args) {
		AccountDao accounts = new AccountDaoDatabase();
		TransactionDao transactions = new TransactionDaoImpl();
		AuthService auth = new AuthServiceImpl(accounts);
		TransactionService trans = new TransactionServiceImpl(accounts, transactions);
		
		Menu checking = new CheckingAccountMenu(account, trans);
		Menu login = new LoginMenuUi(account, auth, checking);
		Menu register = new RegistrationMenu(account, auth, checking);
		
		Menu welcome = new WelcomeMenu(login, register);
		checking.setWelcome(welcome);
		
		Menu nextMenu = welcome;
		
		do{
			nextMenu.setScanner(scan);
			nextMenu.display();
			nextMenu = nextMenu.advance();
		} while (nextMenu != null);
	}
}
