package com.main.ui;

import java.util.Scanner;

import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;
import com.main.services.AuthService;

public class RegistrationMenu implements Menu {

	private Scanner scan;
	private Account account;
	private AuthService auth;
	private Menu checking;
	private Menu nextMenu;
	
	
	public RegistrationMenu(Account account, AuthService auth, Menu checking) {
		super();
		this.account = account;
		this.checking = checking;
		this.auth = auth;
	}

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void display() {
		System.out.println("Please Enter First Name : ");
		String firstName = scan.next();
		
		System.out.println("Please Enter Last Name : ");
		String lastName = scan.next();
		
		System.out.println("Please Enter New Username : ");
		String username = scan.next();
		
		System.out.println("Please Enter Password : ");
		String password = scan.next();
		
		System.out.println("Thank you for registering");
		
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setUsername(username);
		account.setPassword(password);
				
		try {
			auth.registerUser(account);
		} catch (UsernameTaken e) {
			System.out.println("Username already taken");
		}
				
		nextMenu = checking;
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		this.scan = scan;
	}

	@Override
	public void setWelcome(Menu welcome) {
		// TODO Auto-generated method stub
		
	}

}
