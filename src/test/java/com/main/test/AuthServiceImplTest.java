package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.main.dao.AccountDao;
import com.main.dao.AccountDaoKyro;
import com.main.exceptions.AccountNotFound;
import com.main.exceptions.InvalidPassword;
import com.main.exceptions.UserNotFound;
import com.main.pojo.Account;
import com.main.services.AuthService;
import com.main.services.AuthServiceImpl;

class AuthServiceImplTest {

	@Test()
	void isExistingUser() {
		// Arrange
		Account account = new Account("Billy", "1234");
		AccountDao accounts = new AccountDaoKyro();
		AuthService auth = new AuthServiceImpl(accounts);
		
		// Assess
		assertFalse(auth.existingUser(account));
	}

	/*@Test
	void testAuthenticateUser() {
		// Arrange
		Account account = new Account("Billy", "1234");
		AccountDao accounts = new AccountDaoImpl();
		accounts.createAccount(account);
		AuthService auth = new AuthServiceImpl(accounts);
		
		// Act
		auth.authenticateUser(account);
		
		// Assess
	}*/
	
	@Test
	void invalidPassword() throws InvalidPassword, UserNotFound, AccountNotFound {
		// Arrange
		Account account = new Account("Billy", " ");
		AccountDao accounts = new AccountDaoKyro();
		AuthService auth = new AuthServiceImpl(accounts);
		
		// Act
		auth.authenticateUser(account);
		
		// Assess
		assertThrows(UserNotFound.class, () -> {
			System.out.println("Invalid Password");
		});
	}

	@Test
	void testRegisterUser() {
		fail("Not yet implemented");
	}

}
