package com.main.services;

import com.main.exceptions.InvalidPassword;
import com.main.exceptions.UserNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public interface AuthService {
	public boolean existingUser(Account account);
	
	public Account authenticateUser(Account account) throws InvalidPassword, UserNotFound;
	
	public Account registerUser(Account account) throws UsernameTaken;
}
