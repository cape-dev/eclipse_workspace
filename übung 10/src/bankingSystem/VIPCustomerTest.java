/**
 * @author Can Pekesen
 */
package bankingSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VIPCustomerTest {
	
	VIPCustomer test1;

	@Before
	public void setUp(){
		test1 = new VIPCustomer("Dr.", "Hans", "Peter", "bla");
	}
	
	
	@Test
	public void test() {
		assertEquals("Dr. Hans Peter", test1.getFullName());
	}

}
