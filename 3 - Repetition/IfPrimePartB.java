/* Checks how many numbers there are between 2 numbers
 * Daniel Zhang
 * March 3, 2020
 */

import java.util.Scanner;
public class IfPrimePartB {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		while (true) {
			System.out.print("Enter starting number: ");
			int firstNum = in.nextInt();
			System.out.print("Enter ending number: ");
			int secondNum = in.nextInt();
			int counter = 0;
			int squareRoot;
			boolean isPrime = true;

			// For loop checks between 2 entered numbers
			for (int i = firstNum; i <= secondNum; i++) {
				squareRoot = (int) (Math.sqrt(i));
				for (int j = 2; j <= squareRoot; j++) {
					if (i % j != 0) { // If a number is prime, isPrime is set to true
						isPrime = true;
					}

					else {
						isPrime = false; // Otherwise, isPrime is set to false
						break;
					}

				}
				if (isPrime) { // If a number is prime, it will go through and be counted as a prime number
					counter++;
				}
			}

			System.out.println("Number of primes in range: " + counter);
		}


	}
}

