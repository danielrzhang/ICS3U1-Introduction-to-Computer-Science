/* Checks if a number is prime
 * Daniel Zhang
 * March 3, 2020
 */

import java.util.Scanner;
public class IfPrimePartA {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		while (true) {
			System.out.print("Enter an integer: ");
			int number = in.nextInt();
			int squareRoot = (int) (Math.sqrt(number));
			String result = "";

			// 2 and 3 don't go into for loop, so they are checked here
			if (number == 2 || number == 3) {
				result = "Prime";
			}

			else {
				/* Checks for factors between 2 and the square root of a number (There is always a factor between
         2 and the square root of a number in a composite number) */

				for (int i = 2; i <= squareRoot; i++) {
					if (number % i != 0) {
						result = "Prime";
					}

					else {
						result = "Not a prime";
						break;
					}
				}

			}
			System.out.println(result);
		}
	}
}
