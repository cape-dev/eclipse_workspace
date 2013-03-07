/**
 * 
 * @author Can Pekesen
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

	CheckingAccount testAcc;

	@Before
	public void setUp() {
		testAcc = new CheckingAccount(1234, 500000, 0);
	}

	@Test
	public void depositTest() {
		testAcc.deposit(123456);
		assertEquals((500000 + 123456), testAcc.getAmount());
	}

	@Test
	public void withdrawTestFalse1() {
		assertFalse(testAcc.withdraw(1233, 500000));
	}

	@Test
	public void withdrawTestFalse2() {
		assertFalse(testAcc.withdraw(1234, 500001));
	}

	@Test
	public void withdrawTestTrue() {
		assertTrue(testAcc.withdraw(1234, 500000));
		assertEquals(0, testAcc.getAmount());
	}

}
