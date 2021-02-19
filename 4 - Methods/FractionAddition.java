/** Gets input from 2 fractions and finds sum and simplified sum
 * Daniel Zhang
 * March 12, 2020
 */

/**
 * @param 2 numerators and 2 denominators from 2 fractions
 * @return A string containing the two fractions, the sum, and the simplified sum
 */
import java.util.Scanner;
public class FractionAddition {
	public static String AddTwoFractions (int numerator1, int denominator1, int numerator2, int denominator2) {

		// Declaring variables to use for later
		int commonDenominator;
		int firstFactor;
		int secondFactor;
		int multipliedNumerator1;
		int multipliedNumerator2;
		int commonNumerator;
		int dividedNumerator;
		int dividedDenominator;

		String fraction1 = "";
		String fraction2 = "";
		String totalFraction = "";
		String simplifiedFraction = "";

		commonDenominator = denominator1 * denominator2; // Find the common denominator between the two fractions

		firstFactor = commonDenominator / denominator1; // Calculates factor to multiply numerator1 by dividing the common denominator by the original denominator
		secondFactor = commonDenominator / denominator2; // Calculates factor to multiply numerator2 by dividing the common denominator by the original denominator

		multipliedNumerator1 = numerator1 * firstFactor; // Calculates equivalent fraction (numerator1)
		multipliedNumerator2 = numerator2 * secondFactor; // Calculates equivalent fractions (numerator2)

		commonNumerator = multipliedNumerator1 + multipliedNumerator2; // Adds the two numerators together
		dividedNumerator = 1;
		dividedDenominator = 1;

		if (commonNumerator != 0) { // If the numerator does not add up to 0, control flow goes here
			for (int i = 1; i <= Math.min(commonNumerator, commonDenominator); i++) { // Runs through numbers from 1 to smaller numerator
				if (commonNumerator % i == 0 && commonDenominator % i == 0) { // Checks if the factor can divide both numbers
					dividedNumerator = commonNumerator / i;
					dividedDenominator = commonDenominator / i;
				}

				fraction1 = numerator1 + "/" + denominator1; // Formatting first fraction into text
				fraction2 = numerator2 + "/" + denominator2; // Formatting second fraction into text
				totalFraction = commonNumerator + "/" + commonDenominator; // Formatting the sum of the two fractions into text
				if (dividedNumerator % dividedDenominator == 0) { // If the denominator divides the numerator evenly, write it as a whole number
					simplifiedFraction = dividedNumerator / dividedDenominator + ""; // Formats quotient into text
				}

				else { // Else, write it as a fraction
					simplifiedFraction = dividedNumerator + "/" + dividedDenominator; // Formats sum of the simplified fraction into text
				}
			}
		}

		else { // If the numerator sum is 0, control flow goes here
			fraction1 = numerator1 + "/" + denominator1; // Format first fraction into text
			fraction2 = numerator2 + "/" + denominator2; // Format second fraction into text
			totalFraction = commonNumerator + "/" + commonDenominator; // Formats sum of the fraction in text
			simplifiedFraction = "0"; // Sum will always be 0, formatted into text
		}

		// Combine all of the fractions, sum, and simplified fraction into one string (concatenation)
		String result = "Sum = " + fraction1 + " + " + fraction2 + " = " + totalFraction + " = " + simplifiedFraction;
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the numerator1: ");
		int num1 = in.nextInt();
		System.out.print("Enter the denominator1: ");
		int den1 = in.nextInt();
		System.out.print("Enter the numerator2: ");
		int num2 = in.nextInt();
		System.out.print("Enter the denominator2: ");
		int den2 = in.nextInt();
		if (den1 == 0 || den2 == 0) { // If the denominator has 0, print error statement (cannot divide by 0)
			System.out.println("Invalid input! Cannot divide by 0.");
		}

		else { // Otherwise, call the AddTwoFractions method and set input as parameters, prints out result
			String totalString = AddTwoFractions(num1, den1, num2, den2);
			System.out.println(totalString);
		}
	}
}

