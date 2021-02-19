import java.util.Scanner;
public class GuessingGame {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		int randNum = (int) (Math.random()*(20 - 1 + 1) + 1);
		int guess;
		int numGuesses = 0;

		final int GIVE_UP = 0;

		do {
			System.out.print("Enter a number from 1 - 20. Enter 0 to quit: ");
			guess = in.nextInt();

			if (guess != GIVE_UP) {
				if (guess < randNum)
					System.out.println("Too Low");

				else if (guess > randNum)
					System.out.println("Too High");

				else if (guess == randNum)
					System.out.println("You guessed the number!");

				else
					System.out.println("Invalid Number! Enter a number from 1 - 20" );

				numGuesses++;
			}

		} while (guess != randNum && guess != GIVE_UP);

		if (guess == randNum)
			System.out.println("It took you " + numGuesses + " guesses for you to guess the number " + randNum);

		else
			System.out.println("You gave up in " + numGuesses + " guesses. The number is " + randNum);



	}
}




