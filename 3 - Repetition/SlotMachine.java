/* Slot machine that you can earn tokens from
 * Daniel Zhang
 * March 3, 2020
 */

import java.util.Scanner;
public class SlotMachine {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		int tokenCounter = 100;
		char userInput = 'Y';

		do {
			// Generates three random numbers
			int firstNum = (int) (Math.random()*(3 - 1 + 1) + 1);
			int secondNum = (int) (Math.random()*(3 - 1 + 1) + 1);
			int thirdNum = (int) (Math.random()*(3 - 1 + 1) + 1);

			final int SPIN_ONE = 4; // Number of tokens if all numbers are 1
			final int SPIN_TWO = 8; // Number of tokens if all numbers are 2
			final int SPIN_THREE = 12; // Number of tokens if all numbers are 3



			if (userInput == 'Y') {
				System.out.print("You have " + tokenCounter + " tokens. Pull? ");
				userInput = in.next().toUpperCase().charAt(0);
				tokenCounter--;

				System.out.println("[" + firstNum + "]  [" + secondNum + "]  [" + thirdNum + "]"); // Displays the randomly generated numbers

				// If all numbers are 1, program adds 4 tokens and displays the winning message
				if (firstNum == 1 && secondNum == 1 && thirdNum == 1) {
					tokenCounter += SPIN_ONE;
					System.out.println("You won " + SPIN_ONE + " tokens.");
				}

				// If all numbers are 2, program adds 8 tokens and displays the winning message
				else if (firstNum == 2 && secondNum == 2 && thirdNum == 2) {
					tokenCounter += SPIN_TWO;
					System.out.println("You won " + SPIN_TWO + " tokens.");
				}

				// If all numbers are 3, program adds 12 tokens and displays the winning message
				else if (firstNum == 3 && secondNum == 3 && thirdNum == 3) {
					tokenCounter += SPIN_THREE;
					System.out.println("You won " + SPIN_THREE + " tokens.");
				}

				// If none of the numbers match, program displays the losing message
				else {
					System.out.println("You lost.");
				}
			}

			// If the user enters 'N', the program quits
			else if (userInput == 'N') {
				System.out.println("Thanks for playing!");
			}

			else {
				System.out.println("Invalid Entry! Please enter \'Y\' or \'N\'!");
			}

		} while (userInput != 'N');

	}
}


