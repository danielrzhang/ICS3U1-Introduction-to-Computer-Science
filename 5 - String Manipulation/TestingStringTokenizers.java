import java.util.Scanner;
import java.util.StringTokenizer;
public class TestingStringTokenizers {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		StringTokenizer phrase = new StringTokenizer ("One, Two, Three, Four!", " \t\n\r,!?.", false);

		while (phrase.hasMoreTokens()) {
			System.out.println(phrase.nextToken());
		}
	}
}