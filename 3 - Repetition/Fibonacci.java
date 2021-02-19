import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the number of terms you would like in the Fibonacci sequence: ");
		int times = in.nextInt();
		int firstNum = 0;
		int secondNum = 1;
		int total = 0;

		System.out.print(firstNum + " " + secondNum + " ");

		for (int i = 0; i < times - 2; i++) {
			total = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = total;
			System.out.print(total + " ");

		}

		System.out.println();

	}
}



