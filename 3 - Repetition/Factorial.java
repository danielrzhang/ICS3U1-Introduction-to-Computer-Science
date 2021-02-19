import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter a number here: ");
		int number = in.nextInt();
		long counter = 1;

		for (int i = number; i >= 1; i--) {
			counter *= i;
		}

		System.out.println(number + "! = " + counter);
	}
}
