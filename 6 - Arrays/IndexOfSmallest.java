import java.util.Arrays;
import java.util.Scanner;
public class IndexOfSmallest {
	public static int indexOfSmallest (int [] array) {
		int index = 0;
		int smallestNum = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			if (number <= smallestNum) {
				smallestNum = number;
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int randomLength = (int) (Math.random()*(30 - 20 + 1) + 20);
		int [] randomList = new int [randomLength];
		for (int i = 0; i < randomLength; i++) {
			int randNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			randomList[i] = randNum;
		}

		System.out.println(Arrays.toString(randomList));
		int smallestIndex = indexOfSmallest(randomList);
		System.out.println("The index of the smallest number is " + smallestIndex + ".");
	}
}
