package com.main.ui;

import java.util.Scanner;

import com.main.pojo.Account;

public class RegistrationMenu implements Menu {

	private Scanner scan;
	private Menu AccountTypeMenu;
	private Menu nextMenu;
	private Menu WelcomeMenu;
	
	public RegistrationMenu() {
		super();
		this.AccountTypeMenu = new AccountTypeMenu();
		this.WelcomeMenu = new WelcomeMenu();
	}

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void display() {
		// Create an instance of an account
				Account account = new Account();
				
				// Prompt & Set User's Name
				System.out.println("Create An Account");
				System.out.println("Enter New Account Holder's Name: ");
				//String name = ;
				account.setName(scan.nextLine());
				
				//Prompt and Set User's Username
				System.out.println("Enter New Account Username : ");
				String username = scan.nextLine();
				account.setUsername(username);
				
				// Prompt and Set User's Password
				System.out.println("Enter New Account Password : ");
				String password = scan.nextLine();
				account.setPassword(password);
				
				System.out.println(account.getName());
				System.out.println(account.getUsername());
				System.out.println(account.getPassword());
				
				nextMenu = AccountTypeMenu;
				nextMenu.advance();
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

}
