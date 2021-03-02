package com.main;

import java.util.Scanner;

import com.main.dao.AccountDao;
import com.main.dao.AccountDaoKyro;
import com.main.pojo.Account;
import com.main.services.AuthService;
import com.main.services.AuthServiceImpl;
import com.main.ui.CheckingAccountMenu;
import com.main.ui.LoginMenu;
import com.main.ui.Menu;
import com.main.ui.RegistrationMenu;
import com.main.ui.WelcomeMenu;

public class Driver {
	
	public static Scanner scan = new Scanner(System.in);
	public static Account account = new Account();
	
	public static void main(String[] args) {
		AccountDao accounts = new AccountDaoKyro();
		AuthService auth = new AuthServiceImpl(accounts);
		
		Menu checking = new CheckingAccountMenu(account);
		Menu login = new LoginMenu(account, auth, checking);
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
