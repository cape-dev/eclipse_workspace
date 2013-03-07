/**
 * 
 * @author Can Pekesen
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LimitedWithdrawAccountTest {

	LimitedWithdrawAccount testAcc;

	@Before
	public void setUp() {
		testAcc = new LimitedWithdrawAccount(1234, 500000, 100);
	}

	@Test
	public void depositTest() {
		testAcc.deposit(123456);
		assertEquals((500000 + 123456), testAcc.getAmount());
	}

	@Test
	public void withdrawTestFalse1() {
		assertFalse(testAcc.withdraw(1233, 100));
	}

	@Test
	public void withdrawTestFalse2() {
		assertFalse(testAcc.withdraw(1234, 101));
	}

	@Test
	public void withdrawTestTrue() {
		assertTrue(testAcc.withdraw(1234, 100));
		assertEquals((500000 - 100), testAcc.getAmount());
	}

}
