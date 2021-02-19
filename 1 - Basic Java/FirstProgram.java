/** My Very First Java Program
 * Daniel Zhang
 * February 11, 2020
 */

public class FirstProgram {

	public static void main(String[] args) {

		System.out.println("Hello, World!");
		System.out.println("5+6 = " + (5 + 6));
		System.out.println("1024 - 500 = " + (1024 - 500));
		System.out.println("Area = " + (546 * 12));
		System.out.println("10 / 3 = " + (10 / 3));
		System.out.println("10 / 3 = " + (10.0 / 3));
		System.out.println("Square root of 25 = " + (int) (Math.sqrt(25)));
		System.out.println("2 to the power of 3 = " + (int) Math.pow(2, 3));
		System.out.println("Round 100.9323 = " + Math.round(100.9323));
		System.out.println("Round 100.9323 = " + Math.ceil(100.9323));
		System.out.println("Round 100.9323 = " + Math.floor(100.9323));
		System.out.println("max(5, 2) = " + Math.max(5, 2));
		System.out.println("min(5, 2) = " + Math.min(5, 2));
		System.out.println("Random number between 4 and 46 = " + (int)(Math.random()*(56 - 4 + 1) + 4));
		System.out.printf("10 / 3 = %.3f \n", (10.0 / 3));
		System.out.printf("Round 100.9323 = %.2f \n", Math.floor(100.9323));
	}
}
