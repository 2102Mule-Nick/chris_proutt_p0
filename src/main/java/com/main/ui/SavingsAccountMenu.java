package com.main.ui;

import java.util.Scanner;

public class SavingsAccountMenu implements Menu {
	
	private Scanner scan;
	private Menu AccountTypeMenu;
	private Menu nextMenu;
	private Menu WelcomeMenu;
	
	public SavingsAccountMenu() {
		super();
		this.AccountTypeMenu = new AccountTypeMenu();
		this.WelcomeMenu = new WelcomeMenu();
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

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
