import java.util.Scanner;
public class IndexOfTarget {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int randLength = (int) (Math.random()*(30 - 20 + 1) + 20);
		int [] randList = new int [randLength];

		for (int i = 0; i < randLength; i++) {
			int randNum = (int) (Math.random()*(100 - 1 + 1) + 1);
			randList[i] = randNum;
		}


	}
}