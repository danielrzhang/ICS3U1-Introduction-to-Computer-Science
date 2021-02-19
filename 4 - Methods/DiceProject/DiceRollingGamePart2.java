/** Play A Dice-Rolling Game Against an AI
 * Daniel Zhang
 * March 14, 2020
 */

import java.util.Scanner;
public class DiceRollingGamePart2 {

	/** Method to print the beginning rules
	 * @param None
	 * @return Print statements that contain the rules
	 */
	public static void StartRules () {
		System.out.println("Welcome to the Dice Rolling Game!");
		System.out.println("In this game, you will be competing against an AI.");
		System.out.println("You and the AI will start with 0 points each and one 6-sided cube will be rolled.");
		System.out.println("You must guess whether the next roll is higher (H), lower (L), or the same (S) number.");
		System.out.println("You will guess first, and then the AI will guess after you.");
		System.out.println("If you guessed higher or lower, and it is correct, you receive 1 point.");
		System.out.println("If the AI guessed higher or lower, and it is correct, the AI receives 1 point.");
		System.out.println("If you guessed the same number, and it is correct, you receive 3 points.");
		System.out.println("If the AI guessed the same number, and it is correct, the AI receives 3 points.");
		System.out.println("If you guessed incorrectly, you do not receive any points.");
		System.out.println("if the AI guesses incorrectly, it does not receive any points.");
		System.out.println("You win the game if you get to at least 10 points and have more points than the AI.");
		System.out.println("The AI will win the game if it gets to at least 10 points and has more points than you.");
		System.out.print("Press ENTER to begin: ");
	}


	/** Method to generate random first roll
	 * @param None
	 * @return a random number between 1 - 6 which is the first roll
	 */
	public static int rollFirstDice () {
		int firstRoll = (int) (Math.random()*(6 - 1 + 1) + 1); // Generates a random roll between 1 and 6
		return firstRoll;
	}


	/** Method to generate second random roll
	 * @param None
	 * @return a random number between 1 - 6 which is the second roll
	 */
	public static int rollSecondDice () {
		int secondRoll = (int) (Math.random()*(6 - 1 + 1) + 1); // Generates a random roll between 1 and 6
		return secondRoll;
	}

	/** Method to determine what the AI should roll
	 * @param The first roll
	 * @return The computer's guess, in the form of a character
	 */
	public static char computerChoice (int roll) {
		int guess = (int) (Math.random()*(6 - 1 + 1) + 1); // Randomly generates guess from 1 to 5 for percentage value
		char charGuess = ' ';

		if (roll == 6) { // If the first roll is 6, the guess must be 'L'
			charGuess = 'L';
		}

		else if (roll == 1) { // If the first roll is 1, the guess must be 'H'
			charGuess = 'H';
		}

		else { // If the first roll is between 2 and 5, control flow goes here
			if (guess == 1) { // Randomly generated guess, will guess 'S' 20% of the time
				charGuess = 'S';
			}

			else if (guess == 2 || guess == 3) { // Randomly generated guess, will guess 'H' 40% of the time
				charGuess = 'H';
			}

			else { // Randomly generated guess, will guess 'L' 40% of the time
				charGuess = 'L';
			}
		}
		return charGuess;
	}

	/** Method to calculate the player's score
	 * @param The first roll, the second roll, and the current number of points for the player
	 * @return The updated number of points for the player
	 */
	public static int calcPlayerScore (char playerGuess, int firstRoll, int secondRoll, int playerPoints) {
		if (firstRoll < secondRoll && playerGuess == 'H') { // If the second roll is greater than the first roll, and the player entered 'H', add one point
			System.out.println("You gained 1 point.");
			playerPoints++;
		}

		else if (firstRoll > secondRoll && playerGuess == 'L') { // If the second roll is smaller than the first roll, and the player entered 'L', add one point
			System.out.println("You gained 1 point.");
			playerPoints++;
		}

		else if (firstRoll == secondRoll && playerGuess == 'S') { // If the second roll equals the first roll, and the player entered 'S', add 3 points
			System.out.println("You gained 3 points.");
			playerPoints += 3;
		}

		else { // Otherwise, the player does not get points at all
			System.out.println("You gained 0 points.");
		}
		return playerPoints;
	}


	/** Method to calculate the AI's score
	 * @param the first roll, the second roll, and the current number of points for the AI
	 * @return the number of updates points for the AI
	 */
	public static int calcAIScore (char aIGuess, int firstRoll, int secondRoll, int aIPoints) {
		if (firstRoll < secondRoll && aIGuess == 'H') { // If the second roll is greater than the first roll, and the AI chose 'H', add one point
			System.out.println("The AI gained 1 point.");
			aIPoints++;
		}

		else if (firstRoll > secondRoll && aIGuess == 'L') { // If the second roll is less than the first roll, and the AI chose 'L', add one point
			System.out.println("The AI gained 1 point.");
			aIPoints++;
		}

		else if (firstRoll == secondRoll && aIGuess == 'S') { // If the second roll equals the first roll, and the AI chose 'S', add 3 points
			System.out.println("The AI gained 3 points.");
			aIPoints += 3;
		}

		else { // Otherwise, don't add any points
			System.out.println("The AI gained 0 points.");
		}
		return aIPoints;
	}

	// Main Method
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		char playAgain = 'Y'; // playAgain variable is set to 'Y' as default
		int playerPoints = 0; // Player starts with 0 points
		int aIPoints = 0; // AI starts with 0 points
		StartRules(); // Start rules are displayed
		in.nextLine();

		do {
			boolean inPlay = true;
			int firstRoll = rollFirstDice(); // First cube has been rolled
			System.out.println("\nThe first cube has been rolled! The number that the cube has landed on is " + firstRoll + ".");
			System.out.print("Guess if the next number is higher (H), lower (L), or the same (S): ");

			while (inPlay) {

				char playerGuess = in.next().toUpperCase().charAt(0); // Ask the player to enter their guess
				char aIGuess = computerChoice(firstRoll); // The AI makes a decision on what to guess
				int secondRoll = rollSecondDice(); // Second cube has been rolled

				if (playerGuess == 'H' || playerGuess == 'L' || playerGuess == 'S') { // Checks if the user has entered 'H', 'L', or 'S'
					System.out.println("The AI guessed " + aIGuess + ".\n"); // Displays AI's guess

					System.out.println("The second cube was rolled! The number that the cube has landed on is " + secondRoll + ".\n"); // Displays the second cube roll
					playerPoints = calcPlayerScore(playerGuess, firstRoll, secondRoll, playerPoints); // Player points are calculated and printed out
					aIPoints = calcAIScore(aIGuess, firstRoll, secondRoll, aIPoints); // AI points are calculated and printed out
					System.out.println();
					System.out.println("You currently have " + playerPoints + " points."); // Prints out the player's current number of points
					System.out.println("The AI currently has " + aIPoints + " points."); // Prints out the AI's current number of points

					if (playerPoints >= 10 && playerPoints > aIPoints) { // Checks if the number of player points is greater than 10 and greater than the AI's number of points
						System.out.println();
						System.out.println("You won the game! You won with " + playerPoints + " points and the AI had " + aIPoints + " points."); // Prints out winning message
						System.out.print("Would you like to play again (Y/N)? "); // Asks user if they want to play again
						do {
							playAgain = in.next().toUpperCase().charAt(0);
							if (playAgain != 'Y' && playAgain != 'N') { // Checks if the user entered something that is not 'Y' or 'N'
								System.out.print("Invalid input! Please enter Yes (Y) or No (N).");
							}
						} while (playAgain != 'Y' && playAgain != 'N'); // Do-while loop runs while the user does not input 'Y' or 'N'

						playerPoints = 0; // resets player points to 0
						aIPoints = 0; // resets AI points to 0
					}

					else if (aIPoints >= 10 && aIPoints > playerPoints) { // Checks if the number of player points is greater than 10 and greater than the player's points
						System.out.println();
						System.out.println("You lost the game. The AI won with " + aIPoints + " points and you had " + playerPoints + " points."); // Prints out losing message
						System.out.print("Would you like to play again (Y/N)? "); // Asks user if they want to play again
						do {
							playAgain = in.next().toUpperCase().charAt(0);
							if (playAgain != 'Y' && playAgain != 'N') { // Checks if the user entered something that is not 'Y' or 'N'
								System.out.print("Invalid input! Please enter Yes (Y) or No (N).");
							}
						} while (playAgain != 'Y' && playAgain != 'N'); // Do-while loop runs while the user does not input 'Y' or 'N'

						playerPoints = 0; // resets player points to 0
						aIPoints = 0; // resets AI points to 0
					}
					inPlay = false; // Breaks out of while loop to start entire loop over again
				}

				else { // Checks if the users has entered something that is not 'H', 'L', or 'S'
					System.out.print("Invalid input! Please enter higher (H), lower (L), or the same (S).");
				}
			}
		} while (playAgain != 'N'); // Do-while loop runs while the player does not enter 'N'
		System.out.println("The AI says \"Good Match!\" and thank you for playing the Dice Rolling Game!"); // Print quitting message for the user


	}
}
