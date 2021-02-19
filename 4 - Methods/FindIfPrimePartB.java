/** Finds the number of prime numbers between 1 and 100
 * Daniel Zhang
 * March 11, 2020
 */

/**
 * @param The starting number and the ending number are inputted to determine the number of prime numbers between
 * @return the variable 'counter', which stores the number of prime numbers between the startNumber and the endNumber
 */
import java.util.Scanner;
public class FindIfPrimePartB {
	public static int PrimeInRange (int startNum, int endNum) {
		int counter = 0; // Counter starts at 0
		for (int i = startNum; i <= endNum; i++) { // Runs from the startNumber to the endNumber
			if (i == 1) {
				continue;
			}

			else if (i == 2) { // If the for loop reaches 2, add one (doesn't go into loop, counts it as non-prime)
				counter++;
				System.out.print("2 ");
			}
			int sqrtNum = (int) (Math.sqrt(i)); // Get square root of number to increase efficiency
			boolean isPrime = false; // Checks if a number is prime, default is 'false'
			for (int j = 2; j <= sqrtNum + 1; j++) { // Checks the if the number is divisible, checks factors between 2 and square root of number
				if (i % j == 0) { // If number is divisible, the number is not a prime
					isPrime = false;
					break;
				}

				else { // If number is not divisible by numbers from 2 to square root of number, the number is a prime
					isPrime = true;
				}
			}

			if (isPrime) { // If the number is prime, counter increases by 1
				counter++;
				System.out.print(i + " "); // Prints out the primes in one line, just for confirmation (2 is not included)
			}
		}
		return counter; // Return counter to 'main' method
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the start number here: ");
		int startNumber = in.nextInt();
		System.out.print("Enter the end number here: ");
		int endNumber = in.nextInt();
		if (startNumber <= 0 || endNumber <= startNumber) {
			System.out.println("Invalid input! Enter positive numbers only.");
		}

		else {
			int result = PrimeInRange(startNumber, endNumber); // Call the PrimeInRange Method to get the number of primes
			System.out.println("\nThere are " + result + " prime numbers between " + startNumber + " and " + endNumber);
		}
	}
}