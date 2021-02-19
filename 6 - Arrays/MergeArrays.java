import java.util.Arrays;
import java.util.Scanner;
public class MergeArrays {
	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		int firstLength = (int) (Math.random()*(15 - 10 + 1) + 10);
		int secondLength = (int) (Math.random()*(15 - 10 + 1) + 10);
		int [] firstList = new int [firstLength];
		int [] secondList = new int [secondLength];

		for (int i = 0; i < firstLength; i++) {
			int firstRandNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			firstList[i] = firstRandNum;
		}

		for (int j = 0; j < secondLength; j++) {
			int secondRandNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			secondList[j] = secondRandNum;
		}

		System.out.println(Arrays.toString(firstList));
		System.out.println(Arrays.toString(secondList));

		int [] mergedArray = new int [firstLength + secondLength];

		for (int k = 0; k < firstLength; k++) {
			mergedArray[k] = firstList[k];
		}

		for (int m = firstLength; m < mergedArray.length; m++) {
			mergedArray[m] = secondList[m - firstList.length];
		}
		System.out.println(Arrays.toString(mergedArray));

	}
}



