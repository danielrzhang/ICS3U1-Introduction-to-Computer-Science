import java.util.Scanner;
public class UserPickNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Think of a number from 1 and 100." );

		int computerGuess = 50;
		int highNumber = 100;
		int lowNumber = 0;
		char userInput;
		int counter = 0;

		do {
			System.out.print("Is the number " + computerGuess + " (Correct, Too Low, Too High)? ");
			userInput = in.next().toUpperCase().charAt(0);
			counter++;

			if (userInput == 'H' || userInput == 'L' || userInput == 'C') {
				if (userInput == 'H') {
					highNumber = computerGuess;
					computerGuess = highNumber - (highNumber - lowNumber) / 2;
				}

				else if (userInput == 'L') {
					lowNumber = computerGuess;
					computerGuess = (highNumber + lowNumber) / 2;
				}

				else if (userInput == 'C') {
					System.out.println("I got your number in " + counter + " tries!");
				}

				counter++;
			}


			else {
				System.out.println("Invalid input. Enter \'H\', \'L\', or \'C\'");
			}

		} while (userInput != 'C');

	}
}
