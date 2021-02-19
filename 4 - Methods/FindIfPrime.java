/** Determines if a number is prime or not
 * Daniel Zhang
 * March 11, 2020
 */

/**
 * @param Number to be checked
 * @return boolean value if number is prime (true) or not (false)
 */
import java.util.Scanner;
public class FindIfPrime {
	public static boolean isPrime (int number) {
		int sqrtNum = (int) Math.floor(Math.sqrt(number)); // Finds square root of factor to increase efficiency
		boolean ifPrime = true;
		if (number == 2 || number == 3) { // If number is 2 or 3, set to prime
			ifPrime = true;
		}

		else {
			for (int i = 2; i <= sqrtNum; i++) { // Runs through all the factors from 2 to the square root of number
				if (number % i == 0) { // If number is divisible by any factors, it is not prime
					ifPrime = false;
					break;
				}

				else {
					ifPrime = true; // Else, it is a prime number if it is not divisible by any factors
				}
			}
		}
		return ifPrime;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here to check if it is prime: ");
		int number = in.nextInt(); // Asks user to enter the number
		boolean result = isPrime(number); // Function call, returns if the number is prime or not
		System.out.println(result);
	}
}
