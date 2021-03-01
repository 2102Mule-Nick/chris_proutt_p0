package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.dao.AccountDaoImpl;
import com.main.exceptions.AccountNotFound;
import com.main.pojo.Account;

class AccountDaoImplTest {

	private static Account account;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void createNewAccount() {
		// Arrange
		account = new Account();
		AccountDaoImpl listOfAccounts = new AccountDaoImpl(); 
		
		// Act
		listOfAccounts.getAccountList().add(account);
		// Assess
		assertEquals(1, listOfAccounts.getAccountList().size(), "Account should be added");
	}
	
	@Test
	void doesUserNameAlreadyExist() throws AccountNotFound {
		//Arrange
		account = new Account();
		account.setUsername("Billy");
		AccountDaoImpl accounts = new AccountDaoImpl();
		
		// Act
		accounts.getAccountList().add(account);
		Account result = accounts.getAccountbyUsername(account.getUsername());
		
		// Assess
		assertEquals(result, account, "Username already exists");
	}

}
