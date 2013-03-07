/**
 * @author Can Pekesen
 */
package bankingSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {


	Customer customer1, customer2;
	Account account1, account2;
	
	@Before
	public void setUp(){
		customer1 = new Customer("can", "pekesen", "blabla");
		customer2 = new Customer("can", "pekesen", "blabla");
		account1 = new Account(1111, 100, customer1);
		account2 = new Account(1112, 100, customer2);
		
	}
	
//	test1.transfer(5, test3);
//	System.out.println(test1.getAmount());
//	System.out.println(test3.getAmount());
	
	
	// tests whether withdraw can be used on account1 with the parameter 100
	@Test
	public void withdrawTest1(){
		assertTrue(account1.withdraw(100));
		assertEquals(0, account1.getAmount());
	}
	

	// tests whether withdraw can be used on account1 with the parameter 101
	@Test
	public void withdrawTest2(){
		assertFalse(account2.withdraw(101));
		assertEquals(100, account2.getAmount());
	}
	

	// tests whether an amount of 95 could be transfered from account1 to account2
	@Test
	public void transferTestTrue() {
		assertTrue(account1.transfer(95, account2));
		assertEquals(5, account1.getAmount());
		assertEquals(195, account2.getAmount());
	}
	

	// tests whether an amount of 105 could be transfered from account1 to account2
	@Test
	public void transferTestFalse(){
		assertFalse(account1.transfer(105, account2));
		assertEquals(100, account1.getAmount());
		assertEquals(100, account2.getAmount());
	}
	
	
	@Test
	public void depositTest1(){
		account1.deposit(50);
		assertTrue(150 == account1.getAmount());
	}
	
	@Test
	public void depositTest2(){
		account1.deposit(-50);
		assertFalse(50 == account1.getAmount());
	}
	
	

}
