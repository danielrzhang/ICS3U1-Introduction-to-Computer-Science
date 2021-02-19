import java.util.Arrays;
import java.util.Scanner;
public class SortAndFind {
	public static int findIndexOf (int [] array, int target) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				System.out.println(i);
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int [] numberArray = new int [25];
		for (int i = 0; i < 25; i++) {
			int randNum = (int) (Math.random()*(500 - 100 + 1) + 100);
			numberArray[i] = randNum;
		}
		Arrays.sort(numberArray);

		System.out.print("Enter a number you would like to find in the array: ");
		int findNum = in.nextInt();

		int index = findIndexOf(numberArray, findNum);
		System.out.println("The index of the number " + findNum + " is first located at index " + index + ".");
	}
}


