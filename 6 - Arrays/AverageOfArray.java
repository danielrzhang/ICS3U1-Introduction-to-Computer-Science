import java.util.Arrays;
import java.util.Scanner;
public class AverageOfArray {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		int randLength = (int) (Math.random()*(30 - 20 + 1) + 20);
		int [] randList = new int [randLength];

		for (int i = 0; i < randLength; i++) {
			int randNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			randList[i] = randNum;
		}

		System.out.println(Arrays.toString(randList));
		double counter = 0;

		for (int j = 0; j < randList.length; j++) {
			counter += randList[j];
		}

		System.out.println("The average of the numbers in the array is " + (counter / randList.length) + ".");
	}
}