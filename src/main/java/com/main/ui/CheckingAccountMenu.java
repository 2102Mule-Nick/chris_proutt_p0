package com.main.ui;

import java.util.Scanner;

public class CheckingAccountMenu implements Menu {
	
	private Scanner scan;
	private Menu AccountTypeMenu;
	private Menu WelcomeMenu;
	private Menu nextMenu;
	private Menu prevMenu;
	
	public CheckingAccountMenu() {
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
		// TODO Auto-generated method stub

	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return prevMenu;
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
