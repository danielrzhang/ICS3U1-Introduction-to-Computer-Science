import java.util.Arrays;
import java.util.Scanner;
public class SortArray {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int randLength = (int) (Math.random()*(30 - 20 + 1) + 10);
		int [] randList = new int [randLength];

		for (int i = 0; i < randLength; i++) {
			int randNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			randList[i] = randNum;
		}
		System.out.println(Arrays.toString(randList));
		int count = 0;
		for (int j = 0; j < randList.length; j++) {
			if (randList[j] < randList[j - 1] && j != 0) {
				int temp = randList[j - 1];
				randList[j - 1] = randList[j];
				randList[j] = temp;
			}
		}
		System.out.println(Arrays.toString(randList));


	}
}








