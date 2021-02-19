/* Finds the Multiplicative Persistence of an entered number
 * Daniel Zhang
 * March 3, 2020
 */

import java.util.Scanner;
public class MultiplicativePersistence {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int number = in.nextInt();
		int total = 1;
		int tempTotal = 0;
		int counter = 0;
		boolean running = true;

		while (running) {
			if (number != 0) {
				int remainder = number % 10; // Get the last digit through remainder
				total *= remainder; // Multiply the last digit to 'total'
				number /= 10; // Divide the number by 10, because int divided by int will create int, get next digit
			}

			else {
				number = total; // 'number' is reset to the current product of the sums
				tempTotal = total; // 'tempTotal' is reset to 1 to wait for next number
				total = 1; // 'total' is reset to 1 to wait for next number
				counter++; // Number of steps is incremented by 1

			}

			// If the temporary total is equal to the total, the number is one digit and the loop ends
			if (total == tempTotal) {
				running = false;
			}

			System.out.println(total + " " + tempTotal + " " + number);
		}

		System.out.println(counter);

	}
}





