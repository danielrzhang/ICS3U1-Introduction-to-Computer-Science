import java.util.*;
public class GuessNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("Think of a number between 1 and 100 and then press Enter.");
		int guessNum = (int) (Math.random()*(100 - 1 + 1) + 1);

		int lowNum = 0;
		int highNum = 100;
		int mysteryNum;

		boolean running = true;

		while (running) {
			System.out.println("Is the number " + randNum + " (Correct, Low, High) ?");
			char correctLowHigh = in.next().toUpperCase().charAt(0);

			if (
		}

	}
}

