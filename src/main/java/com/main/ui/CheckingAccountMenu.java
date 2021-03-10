package com.main.ui;

import java.util.Scanner;

import com.esotericsoftware.minlog.Log;
import com.main.pojo.Account;
import com.main.pojo.Transaction;
import com.main.services.TransactionService;
import com.main.services.TransactionServiceImpl;

public class CheckingAccountMenu implements Menu {
	
	private Scanner scan;
	private Account account;
	private TransactionService trans;
	private Menu welcome;
	private Menu nextMenu;
	private Menu prevMenu;
	
	public CheckingAccountMenu(Account account, TransactionService trans) {
		super();
		this.account = account;
		this.trans = trans;
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
				scan.nextFloat();
			}
			
			float deposit = scan.nextFloat();
			
			trans.deposit(account, deposit);
			System.out.println("Your current balance is " + account.getBalance());
			nextMenu = this;
		} else if(option == 2) {
			System.out.println("Amount to withdraw : ");
			
			while(!scan.hasNext()) {
				System.out.println("Invalid amount. Enter again :");
				scan.nextFloat();
			}
			
			float withdrawl = scan.nextFloat();
			
			trans.withdrawl(account, withdrawl);
			System.out.println("Your new balance is " + account.getBalance());
			nextMenu = this;
		} else if(option == 3) {
			trans.checkBalance(account);
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

	@Override
	public void setWelcome(Menu welcome) {
		this.welcome = welcome;
	}
}
