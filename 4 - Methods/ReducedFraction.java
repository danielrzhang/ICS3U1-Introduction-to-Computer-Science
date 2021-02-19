/** Gets a fraction and finds its reduced form
 * Daniel Zhang
 * March 12, 2020
 */

/**
 * @param the numerator and the denominator of the fraction
 * @return the reduced form of the fraction in a string
 */
import java.util.Scanner;
public class ReducedFraction {
	public static String Reduced (int numerator, int denominator) {
		int factor = 1;
		int newNumerator = numerator;
		int newDenominator = denominator;
		for (int i = 1; i <= Math.min(numerator, denominator); i++) { // Runs through the factors between 1 and the smaller part of the fraction
			if (numerator % i == 0 && denominator % i == 0) { // Checks if the number is divisible by a factor. If it is, it is set to divide the numerator and denominator
				newNumerator = numerator / i;
				newDenominator = denominator / i;
			}
		}

		String result = newNumerator + "/" + newDenominator; // Formats the fraction with reduced numerator and denominator into string
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the numerator: ");
		int firstNumerator = in.nextInt();
		System.out.print("Enter the denominator: ");
		int firstDenominator = in.nextInt();

		// Error statement will occur if the denominator is equal to 0, cannot divide by 0
		if (firstDenominator == 0) {
			System.out.println("Invalid input! Cannot divide by 0.");
		}

		else { // Otherwise, call the method and input the numerator and denominator parameters
			String reducedFraction = Reduced(firstNumerator, firstDenominator);
			System.out.println("The reduced fraction is " + reducedFraction);
		}
	}
}




