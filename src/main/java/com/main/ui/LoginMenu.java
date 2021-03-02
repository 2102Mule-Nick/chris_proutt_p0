package com.main.ui;

import java.util.Scanner;

import com.main.exceptions.AccountNotFound;
import com.main.exceptions.InvalidPassword;
import com.main.exceptions.UserNotFound;
import com.main.pojo.Account;
import com.main.services.AuthService;

public class LoginMenu implements Menu {
	
	private Scanner scan;
	private Account account;
	private AuthService auth;
	private Menu checking;
	private Menu nextMenu;
	
	// Constructor
	public LoginMenu(Account account, AuthService auth, Menu checking) {
		super();
		this.account = account;
		this.auth = auth;
		this.checking = checking;
	}

	// To the next Menu
	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}
	
	// Display options to user
	@Override
	public void display() {
		//Prompt and receive information
		System.out.println("Welcome back");
		System.out.print("Enter your username: ");
		this.account.setUsername(scan.nextLine());
		
		System.out.print("Enter your password");
		this.account.setPassword(scan.nextLine());
		
		// Authenticate account information
		try {
			auth.authenticateUser(account);
		} catch (InvalidPassword e) {
			System.out.println("Invalid Password");
			e.printStackTrace();
		} catch (UserNotFound e) {
			System.out.println("Invalid username");
			e.printStackTrace();
		} catch (AccountNotFound e) {
			System.out.println("Account not found.");
			e.printStackTrace();
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
