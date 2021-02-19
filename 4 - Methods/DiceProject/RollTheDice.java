/** 2 dice rolling game to win points
 * Daniel Zhang
 * April 5, 2020
 */

import java.util.Scanner;
public class RollTheDice {


	public static void PrintRules () {
		System.out.println("Welcome to the Dice Rolling Game!");
		System.out.println("In this game, you start with 0 points and a one 6-sided cube will be rolled.");
		System.out.println("You must guess whether the next roll is higher (H), lower (L), or the same (S) number.");
		System.out.println("If you guessed higher or lower, and it is correct, you receive 1 point.");
		System.out.println("If you guessed the same number, and it is correct, you receive 3 points.");
		System.out.println("If you guessed higher or lower, and it is wrong, you lose 1 point.");
		System.out.println("If you guessed the same number, and it is wrong, you lose 3 points.");
		System.out.println("You win if you get 10 points or more, but you can quit any time.");
		System.out.print("Press ENTER to begin: ");
	}

	public static int GenerateFirstRoll () {
		int firstRoll = (int) (Math.random()*(6 - 1 + 1) + 1);
		return firstRoll;
	}

	public static int GenerateSecondRollResult (int firstRoll, char charInput, int points) {
		int secondRoll = (int) (Math.random()*(6 - 1 + 1) + 1);
		System.out.println("The second roll is " + secondRoll + ".");
		if (firstRoll < secondRoll && charInput == 'H') {
			System.out.println("You gained 1 point.");
			points++;
		}

		else if (firstRoll > secondRoll && charInput == 'L') {
			System.out.println("You gained 1 point.");
			points++;
		}

		else if (firstRoll == secondRoll && charInput == 'S') {
			System.out.println("You gained 3 points.");
			points += 3;
		}

		else if (firstRoll <= secondRoll && charInput == 'L') {
			System.out.println("You lost 1 point.");
			points--;
		}

		else if (firstRoll >= secondRoll && charInput == 'H') {
			System.out.println("You lost 1 point.");
			points--;
		}

		else if (firstRoll != secondRoll && charInput == 'S') {
			System.out.println("You lost 3 points.");
			points -= 3;
		}
		return points;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		char playAgain = 'Y';
		int pointCounter = 0;
		PrintRules();
		in.nextLine();

		do {
			int firstCubeRoll = GenerateFirstRoll();
			System.out.println("\nThe first cube was rolled! The number is " + firstCubeRoll + ".");
			System.out.print("Guess if the next number will be a higher (H), lower (L), or the same (S) number: ");
			boolean running = true;

			while (running) {
				char characterInput = in.next().toUpperCase().charAt(0);
				if (characterInput == 'H' || characterInput == 'L' || characterInput == 'S') {
					pointCounter = GenerateSecondRollResult(firstCubeRoll, characterInput, pointCounter);
					System.out.println("You currently have " + pointCounter + " points.");
					System.out.println("Would you like to play again (Y/N)? ");
					playAgain = in.next().toUpperCase().charAt(0);
					running = false;

				}

				else {
					System.out.println("Invalid input! Please enter H (High), L (Low), or S (Same).");
				}
			}



		} while (playAgain != 'N' && pointCounter < 10);
		System.out.println("Thank you for playing the Dice Rolling Game!");
	}
}






