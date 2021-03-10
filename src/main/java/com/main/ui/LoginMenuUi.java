package com.main.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.esotericsoftware.minlog.Log;
import com.main.exceptions.AccountNotFound;
import com.main.exceptions.InvalidPassword;
import com.main.exceptions.UserNotFound;
import com.main.pojo.Account;
import com.main.services.AuthService;

public class LoginMenuUi implements Menu {
	
	Logger log = Logger.getRootLogger();
	
	private Scanner scan;
	private Account account;
	private AuthService auth;
	private Menu checking;
	private Menu nextMenu;
	
	public LoginMenuUi(Account account, AuthService auth, Menu checking) {
		super();
		this.account = account;
		this.auth = auth;
		this.checking = checking;
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void display() {
				
		System.out.println("Login");
		System.out.println("Enter a username : ");
		String username = scan.next();
		System.out.println("Enter a password : ");
		String password = scan.next();
		
		account.setUsername(username);
		account.setPassword(password);
		
		try {
			auth.authenticateUser(account);
			nextMenu = checking;
		} catch (InvalidPassword | UserNotFound | AccountNotFound e) {
			Log.error("Account not authenticated");
		}
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public void setWelcome(Menu welcome) {
		// TODO Auto-generated method stub

	}

}
