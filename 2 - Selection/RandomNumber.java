import java.util.Scanner;
public class RandomNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Guess a number from 5 to 20: ");
		int number = in.nextInt();

		// (Upper - lower + 1) + lower
		int randNum = (int) (Math.random()*(20 - 5 + 1) + 5);

		if (number >= 5 && number <= 20) {
			if (randNum == number) {
				System.out.println("You guessed the number correctly! The number was " + randNum + ".");
			}

			else {
				System.out.println("You guessed the number incorrectly! The number was " + randNum + ".");
			}
		}

		else {
			System.out.println("Invalid number! Enter a number between 5 and 20.");
		}
	}
}

