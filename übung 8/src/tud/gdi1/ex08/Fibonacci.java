/**
 * 
 */
package tud.gdi1.ex08;

/**
 * @author Can Pekesen
 * 
 */
public class Fibonacci {

	/**
	 * represents a test for the method fib
	 */
	public static void main(String[] args) {
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));
		System.out.println(fib(8));
		System.out.println(fib(9));
		System.out.println(fib(0));
		System.out.println(fib(-3));
		System.out.println(fib(23));

	}

	/**
	 * computes the n'th fibonacci number
	 * 
	 * @param n
	 *            the n'th fibonacci number
	 * @return returns the n'th fibonacci number
	 */
	public static int fib(int n) {
		int a, b, fib;
		fib = 0;
		b = 1;

		for (int i = 2; i <= n; i++) {
			a = b;
			b = fib;
			fib = a + b;

		}
		return fib;

	}

}
