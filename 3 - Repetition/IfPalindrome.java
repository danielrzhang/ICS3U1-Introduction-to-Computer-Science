/* Determines if a number is a palindrome or not
 * Daniel Zhang
 * March 3, 2020
 */

import java.util.Scanner;
public class IfPalindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter a number here: ");
		long originalNumber = in.nextLong();
		long copyNumber = originalNumber; // Copies the number for the end, variable 'number' will be modified
		long reverseNumber = 0;

		// Reverses the digits in the number
		while (originalNumber != 0) {
			long onesDigit = originalNumber % 10; // Gets the remainder of originalNumber
			reverseNumber = (reverseNumber * 10) + onesDigit; // Adds the remainder to previous reverseNumber
			originalNumber /= 10; // Divides originalNumber by 10
		}

		if (copyNumber == reverseNumber) { // If copiedNumber is equal to reverseNumber, print out that the number is a palindrome
			System.out.println("The number " + copyNumber + " is a palindrome.");
		}

		else { // If copiedNumber is not equal to reverseNumber, print out that the number is not a palindrome
			System.out.println("The number " + copyNumber + " is not a palindrome.");
		}

	}
}