package Bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Account_test {

	Account a,b;
	
	@Before
	public void setUp() throws Exception {
		a = new Account(1,200,0);
		b = new Account(2,500,0);
	}

	@Test
	public void deposit() {
		a.deposit(200);
		assertEquals(400, a.getKontostand());
	}
	
	@Test
	public void widthdraw(){
		assertTrue(a.withdraw(100));
		assertEquals(100, a.getKontostand());
		
		assertFalse(a.withdraw(200));
		assertEquals(100, a.getKontostand());
	}
	
	@Test
	public void transfer(){
		assertTrue(a.transfer(100,b));
		assertEquals(100,a.getKontostand());
		assertEquals(600,b.getKontostand());
		
		assertFalse(a.transfer(200, b));
		assertEquals(100,a.getKontostand());
		assertEquals(600,b.getKontostand());
	}

}
