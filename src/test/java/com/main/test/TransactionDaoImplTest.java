package com.main.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.main.dao.TransactionDao;
import com.main.dao.TransactionDaoImpl;
import com.main.pojo.Account;
import com.main.pojo.Transaction;
import com.main.utilies.DatabaseConnection;

@ExtendWith(MockitoExtension.class)
class TransactionDaoImplTest {

	@Mock
	private Connection conn;
	
	TransactionDao daoPostgres; 
	
	@BeforeEach
	void setUp() throws Exception {
		daoPostgres = new TransactionDaoImpl();
		
		PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement("delete from transactions where user_id = 3");
		
		pstmt.executeUpdate();
	}

	@AfterEach
	void tearDown() throws Exception {
		PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement("delete from transactions where user_id = 3");
		
		pstmt.executeUpdate();
	}

	
	
	/*@Test
	void testCreateTransation() throws SQLException {
		//creating a real stmt to be able to actually communicate with our db
		String sql = "insert into transactions (amount, opening_balance, closing_balance) values (?, ?, ?)";
		
		Connection realConnection = DatabaseConnection.getConnection();
		
		PreparedStatement realStmt = realConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		//Spying on our real stmt, so that we can later verify the correct methods are invoked
		PreparedStatement spy = Mockito.spy(realStmt);
		
		when(conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).thenReturn(spy));
		
								
		//setting up our Mock connection, to reaturn our real stmt, we are spying on
		//if we did not do this, and used a real connection on this test, the connection would create
		//a new statement inside of our createCart method, and we could not spy on it
		when(conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)).thenReturn(spy);
				
		daoPostgres.setConn(conn);
				
		//setting up the cart we want to create
		Account account = new Account("Bob", "1234");
		Transaction transaction = new Transaction();
				
		transaction.setAmount(30.0f);

		transaction.setUser_id(3);
				
		transaction.setType("deposit");
				
		account.setBalance(0);
				
		//call the create cart method that we are testing
		daoPostgres.createTransation(account, transaction);;
				
		//verifying all the correct methods are being called on our REAL stmt
		//this can only work because we are spying on the stmt
		verify(spy).setInt(1, transaction.getUser_id());
				
		verify(spy).setFloat(2, cart.getTotal());
				
		verify(spy).executeUpdate();
				
		//making a second call to the db, to ensure that the cart was actually created
		PreparedStatement checkStmt = DatabaseConnection.getConnection().prepareStatement("select * from cart where user_id = 30");
				
		ResultSet rs = checkStmt.executeQuery();
				
		assertTrue(rs.next());
	}*/

	@Test
	void testGetTransaction() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteTransaction() {
		fail("Not yet implemented");
	}

}
