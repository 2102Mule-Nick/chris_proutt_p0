package com.main.ui;

import java.util.Scanner;

import com.esotericsoftware.minlog.Log;
import com.main.pojo.Account;

public class CheckingAccountMenu implements Menu {
	
	private Scanner scan;
	private Account account;
	private Menu welcome;
	private Menu nextMenu;
	private Menu prevMenu;
	
	public CheckingAccountMenu(Account account) {
		super();
		this.account = account;
	}

	@Override
	public Menu advance() {
		return nextMenu;
	}

	@Override
	public void display() {
		
		// Prompt Checking Options
		System.out.println("Checking Account Menu");
		System.out.println("1 - Deposit Money");
		System.out.println("2 - Withdraw Money");
		System.out.println("3 - Check Balance");
		System.out.println("4 - Exit");
		System.out.print("\nEnter your choice : ");
		int option = scan.nextInt();
		
		
		if(option == 1) {
			System.out.print("Amount to deposit : ");
			
			while(!scan.hasNext()) {
				System.out.println("Invalid amount. Enter again :");
				scan.nextDouble();
			}
			
			double deposit = scan.nextDouble();
			deposit(account, deposit);
			System.out.println("Your current balance is " + account.getBalance());
			nextMenu = welcome;
		} else if(option == 2) {
			System.out.println("Amount to withdraw : ");
			
			while(!scan.hasNext()) {
				System.out.println("Invalid amount. Enter again :");
				scan.nextDouble();
			}
			
			double withdrawl = scan.nextDouble();
			withdraw(account, withdrawl);
			System.out.println("Your new balance is " + account.getBalance());
			nextMenu = welcome;
		} else if(option == 3) {
			checkBalance(account);
		} else if(option == 4) {
			System.out.println("Thanks for banking with us");
			nextMenu = welcome;
		} else {
			System.out.println("Invalid input! Please enter again: ");
			option = scan.nextInt();
		}
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
		this.scan = scan;
	}

	public void deposit(Account account, double deposit) {
		if(deposit > 0) {
			float balance = account.getBalance();
			balance += deposit;
			account.setBalance(balance);
		}
	}
	
	public void withdraw(Account account, double withdrawl) {
		if(withdrawl < account.getBalance()) {
			float balance = account.getBalance();
			balance -= withdrawl;
			account.setBalance(balance);
			Log.info("Account balance updated");
		}
	}
	
	public void checkBalance(Account account) {
		System.out.println("Your balance is " + account.getBalance());
	}

	@Override
	public void setWelcome(Menu welcome) {
		this.welcome = welcome;
	}
}
