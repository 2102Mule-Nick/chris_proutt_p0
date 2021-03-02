package com.main.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {
	private Scanner scan;
	private Menu nextMenu;
	private Menu loginMenu;
	private Menu registrationMenu;
	
	public WelcomeMenu(Menu login, Menu register) {
		super();
		this.loginMenu = login;
		this.registrationMenu = register;
	}
	
	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void display() {
		System.out.println("\n-------------------");
		System.out.println("WELCOME TO BANK OF JAVA");
		System.out.println("-------------------\n");
		System.out.println("Menu options");
		System.out.println("1: Register Account");
		System.out.println("2. Login.");
		System.out.println("3. Exit.");
		System.out.print("\nEnter your choice : ");
		int option = scan.nextInt();
		
		if(option == 1) {
			registrationMenu.setScanner(scan);
			nextMenu = registrationMenu;
		} else if(option == 2) {
			loginMenu.setScanner(scan);
			nextMenu = loginMenu;
		} else if(option == 3) {
			System.out.println("Thank you for banking with us.");
			System.exit(1);
		}
		
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
		this.scan = scan;		
	}

	@Override
	public void setWelcome(Menu welcome) {
		// TODO Auto-generated method stub
		
	}

}
