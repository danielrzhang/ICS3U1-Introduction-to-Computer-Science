import java.util.Scanner;
public class FiftyRandomNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		int counter = 0;
		int bigNum = 10;
		int smallNum = 100;
		int randNum;

		for (int i = 0; i < 50; i++) {
			randNum = (int) (Math.random()*(100 - 10 + 1) + 10);
			System.out.print(randNum + " ");
			counter += randNum;

			if (bigNum <= randNum)
				bigNum = randNum;

			if (smallNum >= randNum)
				smallNum = randNum;
		}

		double average = counter / 50.0;
		System.out.println("\n\nThe average of the 50 numbers is " + average + ".");
		System.out.println("The largest number in the 50 numbers is " + bigNum + ".");
		System.out.println("The smallest in the 50 numbers is " + smallNum + ".");

	}
}
