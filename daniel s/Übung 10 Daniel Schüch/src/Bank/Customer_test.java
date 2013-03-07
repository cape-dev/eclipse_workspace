package Bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Customer_test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertFalse(new Customer("Daniel", "Schüch", "Darmstadt") == new Customer("Daniel", "Schüch", "Darmstadt"));
		/**
		 * Hier wird auf GLeichheit der Speicheradresse geprüft.
		 * Da jedoch beide Objekte an unterschiedlich Speicherplätzen liegen ist assertFalse true.
		 */
		
	}
	
	@Test
	public void testnew(){
		Customer a = new Customer("Daniel","Schuech","Darmstadt");
		assertTrue(a.equals(new Customer("Daniel","Schuech","Darmstadt")));
		
	}

}
