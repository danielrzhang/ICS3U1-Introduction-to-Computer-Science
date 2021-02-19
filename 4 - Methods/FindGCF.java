/** Finds the greatest common factor between two numbers
 * Daniel Zhang
 * March 11, 2020
 */

/**
 * @param num1 and num2 are the numbers to be inputted
 * @return maxFactor is their greatest common factor
 */
import java.util.Scanner;
public class FindGCF {
	// Method to find the greatest common factor between the two numbers
	private static String highestCommonFactor (int num1, int num2) {
		int smallerNumber;
		String maxFactor = "";
		num1 = Math.abs(num1); // Finds the absolute value to turn to negative positive
		num2 = Math.abs(num2); // Finds the absolute value to turn to negative positive
		if (num1 != 0 && num2 != 0) { // If the numbers are not equal to 0, control flow goes in here
			if (num1 >= num2) {
				smallerNumber = num2; // Finds smallest number between the two numbers
			}

			else {
				smallerNumber = num1; // Finds smallest number between the two numbers
			}

			for (int i = 1; i <= smallerNumber; i++) { // Finds factors up to the smallest number
				if (num1 % i == 0 && num2 % i == 0) {
					maxFactor = i + ".";
				}
			}
		}

		else { // Control flow goes in here if the numbers are equal to 0
			if (num1 > num2) { // Gets largest number for factor
				maxFactor = num1 + ".";
			}

			else if (num2 > num1) { // Gets largest number for factor
				maxFactor = num2 + ".";
			}

			else { // If both numbers are 0, there is infinite factors
				maxFactor = "0";

			}
		}
		return maxFactor;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int num1 = in.nextInt();
		System.out.print("Enter another number here: ");
		int num2 = in.nextInt();
		String gcf = highestCommonFactor(num1, num2);
		System.out.println("The greatest common factor of " + num1 + " and " + num2 + " is " + gcf);
	}
}