package Bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VIPCustomer_test {

	VIPCustomer a;
	
	@Before
	public void setUp() throws Exception {
		a = new VIPCustomer("Dr.","Max","Mustermann","Strasse 1 Darmstadt");
	}

	@Test
	public void test() {
		assertEquals("Dr. Max Mustermann", a.getFullName());
	}

}
