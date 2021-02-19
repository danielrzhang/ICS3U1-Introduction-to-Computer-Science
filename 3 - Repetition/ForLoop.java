import java.util.Scanner;
public class ForLoop {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		for (int i = 0; i < 50; i++) {
			int randNum = (int) (Math.random()*(100 - 10 + 1) + 10);
			System.out.println(randNum);
		}
	}
}
