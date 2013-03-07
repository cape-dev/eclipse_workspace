/**
 * @author Can Pekesen
 */
package bankingSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	Customer test1, test2, test3;

	@Before
	public void setUp() {
		test1 = new Customer("can", "pekesen", "bla");
		test2 = new Customer("can", "pekesen", "bla");
		test3 = new Customer("hans", "peter", "nimmerland");
	}

	@Test
	public void false_assertion() {
		assertFalse((new Customer("can", "pekesen", "bla")) == (new Customer("can", "pekesen", "bla")));
	}

	/**
	 * Erklärung:
	 * beide instanzen der klasse customer haben identische werte, dennoch sind die objekte nicht
	 * identisch. sie liegen beide auf verschiedenen speicheradressen, was sie eben nicht identisch macht. 
	 */
	
	
	
	@Test
	public void equalsTestTrue(){
		assertTrue(test1.equals(test2));
	}

	
	@Test
	public void equalsTestFalse(){
		assertFalse(test1.equals(test3));
	}

}
