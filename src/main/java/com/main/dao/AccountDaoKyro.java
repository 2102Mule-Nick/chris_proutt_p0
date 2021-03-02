package com.main.dao;

import java.io.File;
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
	
	public AccountDaoKyro() {
		super();
		kryo.register(Account.class);
	}
	
	@Override
	public boolean createAccount(Account account) throws UsernameTaken {
		// Is Account User Null
		if(account == null) {
			return false;
		}
		
		// Make sure a Folder exists
		File accountDir = new File("accounts\\");
		if(!accountDir.exists()) {
			accountDir.mkdir();
		}
		
		// Make sure a file exists
		String fileName = FOLDER_NAME + account.getUsername() + FILE_EXTENSION;
		File file = new File(fileName);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				log.error("Couldn't create a file named : " + fileName);
				return false;
			}
		}
		
		log.info("Starting to create user");
		
		try(FileOutputStream outputStream = new FileOutputStream(FOLDER_NAME + account.getUsername() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, account);
			output.close();
			return true;
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Account> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountbyUsername(String username) throws AccountNotFound {
		log.info("Starting to create account");
		
		// Make sure a file exists
				String fileName = FOLDER_NAME + username + FILE_EXTENSION;
				File file = new File(fileName);
				
				if(!file.exists()) {
					try {
						file.createNewFile();
					} catch(IOException e) {
						log.error("Couldn't create a file named : " + fileName);
						return null;
					}
				}
		
		// Return input stream
		try (FileInputStream inputStream = new FileInputStream(FOLDER_NAME + username + FILE_EXTENSION)) {
			Input input = new Input(inputStream);
			Account account = kryo.readObject(input, Account.class);
			input.close();
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
