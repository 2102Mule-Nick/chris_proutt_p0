package com.main.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.main.exceptions.AccountNotFound;
import com.main.exceptions.UsernameTaken;
import com.main.pojo.Account;

public class AccountDaoKyro implements AccountDao {
	
	private Kryo kryo = new Kryo();

	private Logger log = Logger.getRootLogger();
	
	private static final String FOLDER_NAME = "accounts\\";
	
	private static final String FILE_EXTENSION = ".dat";
	
	@Override
	public void createAccount(Account account) throws UsernameTaken {
		log.info("Starting to create user");
		
		try(FileOutputStream outputStream = new FileOutputStream(FOLDER_NAME + account.getUsername() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, account);
			output.close();
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Account> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountbyUsername(String username) throws AccountNotFound {
		try (FileInputStream inputStream = new FileInputStream(FOLDER_NAME + username + FILE_EXTENSION)) {
			Input input = new Input(inputStream);
			Account account = kryo.readObject(input, Account.class);
			input.close();
			System.out.println(account);
			return account;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAccount(Account account) {
		// TODO Auto-generated method stub

	}

}
