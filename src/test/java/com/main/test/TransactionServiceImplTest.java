package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.main.dao.AccountDaoDatabase;
import com.main.pojo.Account;
import com.main.pojo.Transaction;
import com.main.utilies.DatabaseConnection;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
	
	@Mock
	private Connection conn;
	
	AccountDaoDatabase daoPostgres;
	
	@Before
	void setUp() throws Exception {
		
	}

	@After
	void tearDown() throws Exception {
		
	}

	@Test
	void testCreateTransaction() throws SQLException {
		String sql = "Insert into transactions(user_id, amount) values (?, ?)";
		
		Connection realConnection = DatabaseConnection.getConnection();
		
		PreparedStatement realStmt = realConnection.prepareStatement(sql);
		
	}
	
	@Test
	void testUpdatebalance(Account account, Transaction transaction) {
		fail("Not yet implemented");
	}

	@Test
	void testGetTransaction() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteTransaction() {
		fail("Not yet implemented");
	}

}
