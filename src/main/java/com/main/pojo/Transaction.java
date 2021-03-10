package com.main.pojo;

public class Transaction {

	private String type;
	private float amount;
	private int user_id;
	private int account_id;
	private float opening_balance;
	private float closing_balance;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public float getOpening_balance() {
		return opening_balance;
	}

	public void setOpening_balance(float opening_balance) {
		this.opening_balance = opening_balance;
	}

	public float getClosing_balance() {
		return closing_balance;
	}

	public void setClosing_balance(float closing_balance) {
		this.closing_balance = closing_balance;
	}

	
	

}
