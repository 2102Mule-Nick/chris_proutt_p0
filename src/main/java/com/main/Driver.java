package com.main;

import java.util.Scanner;

import com.main.dao.AccountDao;
import com.main.dao.AccountDaoImpl;
import com.main.ui.Menu;
import com.main.ui.WelcomeMenu;

public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountDao accounts = new AccountDaoImpl();
		// AuthService auth = new AustServiceImpl();
		Menu welcome = new WelcomeMenu();
		welcome.setScanner(scan);
		welcome.display();		
		
		// Display welcome Menu
		
		// Move forward to next menu according to action
		
		// Restart after action is done
	}

}
