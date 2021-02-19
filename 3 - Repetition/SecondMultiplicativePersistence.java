/* Finds the multiplicative persistence of a number
 * Daniel Zhang
 * March 4, 2020
 */

import java.util.Scanner;
public class SecondMultiplicativePersistence {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int number = in.nextInt();
		int copyNumber = number; // Copies the integer input to store aside for later use
		int multiplyNumber = 1; // Number that accumulates and is multiplied into the digit
		int counter = 0;

		while (copyNumber > 9) {
			int lastDigit = number % 10; // Gets the remainder of the last digit
			multiplyNumber *= lastDigit; // Multiply last digit to the accumulating number
			number /= 10; // Divides the original number by 10 to obtain the next digit

			if (number == 0) { // If all the digits are multiplied, reset
				number = multiplyNumber; // New number becomes accumulating number
				copyNumber = multiplyNumber; // Copied number also becomes accumulating number
				multiplyNumber = 1; // Accumulating number is reset to one
				counter++;

			}
		}
		System.out.println(counter);
	}
}



