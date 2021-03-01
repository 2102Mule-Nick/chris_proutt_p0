package com.main.pojo;

public class Account {
	
	private String name;
	
	private String username;
	
	private String password;
	
	private int balance;
	
	public Account() {
		super();
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
