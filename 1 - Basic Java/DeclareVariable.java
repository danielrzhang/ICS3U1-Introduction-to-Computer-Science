/** String, Integer, Character, and Double formatting using printf
 * Daniel Zhang
 * February 18, 2020
 */

public class DeclareVariable {
	public static void main (String[] args) {
		int x = 20;
		double y = 5.5;
		char c = 'J';
		String note = "Hello Java";
		System.out.printf("The formatted output is %d %.6f %c %s%n", x, y, c, note);
	}
}