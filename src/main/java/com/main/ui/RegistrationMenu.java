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
				
				// Prompt & Set User's Name
				System.out.println("Create An Account");
				
				//Prompt and Set User's Username
				System.out.println("Enter New Account Username : ");
				this.account.setUsername(scan.nextLine());
				
				// Prompt and Set User's Password
				System.out.println("Enter New Account Password : ");
				this.account.setPassword(scan.nextLine());
				
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
