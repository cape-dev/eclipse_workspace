/**
 * @author Can Pekesen
 */

package tud.gdi1.ex08;

public class Strings {

	/**
	 * represents a test for the method "join"
	 */
	public static void main(String[] args) {
		//test1
		String[] test1 = new String[] {"Hello","World","!!!"};
		System.out.println(join(test1));
		//test2
		String[] test2 = new String[] {"Dies","ist","ein","Test"};
		System.out.println(join(test2));
		//test3
		String[] test3 = new String[] {"Dieses","Programm","verknüpft","Strings"};
		System.out.println(join(test3));
	}
	
	
	/**
	 * Links the parts of one array to one big string.
	 * 
	 * @param a This parameter is the given Array.
	 * @return Returns a String
	 */
	public static String join(String[] a){
		String s = "";
		
		for (int i = 0; i < a.length; i++) {
			s += a[i];
			
		}
		return s;
		
	}

}
