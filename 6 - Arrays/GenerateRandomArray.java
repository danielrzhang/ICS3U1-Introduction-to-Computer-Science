import java.util.Arrays;
import java.util.Scanner;
public class GenerateRandomArray {
	public static int [] generateArray () {
		int randLength = (int) (Math.random()*(30 - 20 + 1) + 10);
		int [] randList = new int [randLength];

		for (int i = 0; i < randLength; i++) {
			int randNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			randList[i] = randNum;
		}

		return randList;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int [] list = generateArray();
		System.out.println(Arrays.toString(list));
	}
}

