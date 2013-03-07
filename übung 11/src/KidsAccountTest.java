/**
 * 
 * @author Can Pekesen
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KidsAccountTest {

	KidsAccount testAcc1, testAcc2;

	@Before
	public void setUp() {
		testAcc1 = new KidsAccount(1234, 1500);
		testAcc2 = new KidsAccount(1234, 500);
	}

	@Test
	public void depositTest() {
		testAcc1.deposit(123456);
		assertEquals((1500 + 123456), testAcc1.getAmount());
	}

	@Test
	public void withdrawTestFalse1() {
		assertFalse(testAcc1.withdraw(1233, 100));
	}

	@Test
	public void withdrawTestFalse2() {
		assertFalse(testAcc1.withdraw(1234, 1001));
	}

	@Test
	public void withdrawTestFalse3() {
		assertFalse(testAcc2.withdraw(1234, 1000));
	}

	@Test
	public void withdrawTestTrue() {
		assertTrue(testAcc1.withdraw(1234, 1000));
		assertEquals((1500 - 1000), testAcc1.getAmount());
	}

}
