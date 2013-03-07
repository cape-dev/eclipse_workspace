/**
 * @author Can Pekesen
 */

package tud.gdi1.ex08;

public class Calculator {

	/**
	 * this method represents a test for the method ggt
	 */
	public static void main(String[] args) {
		System.out.println(ggt(6, 20));
		System.out.println(ggt(9, 19));
		System.out.println(ggt(0, 4));

	}

	/**
	 * returns the highest divisor of two positive integer
	 * 
	 * @param a
	 *            int!
	 * @param b
	 *            int!
	 * @return returns the highest divisor of two positive integer
	 */
	public static int ggt(int a, int b) {
		if (a == 0)
			return b;
		else

			while (b != 0)
				if (a > b)
					a = a - b;
				else
					b = b - a;
		return a;

	}

}
