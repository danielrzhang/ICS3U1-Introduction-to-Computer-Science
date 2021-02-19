import java.util.Scanner;
public class GetFactorial {
	public static long factorial (int startNum) {
		long counter = 1;
		if (startNum == 0) {
			counter = 1;
		}

		else {
			for (int i = startNum; i >= 1; i--) {
				counter *= i;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		int number = 0;
		do {
			Scanner in = new Scanner (System.in);
			System.out.print("Enter a number to find the factorial: ");
			number = in.nextInt();
			if (number < 0) {
				System.out.println("Invalid input! Enter a number 0 or above");
			}

			else {
				long result = factorial(number);
				System.out.println(number + "! is equal to " + result);
			}
		} while (true);
	}
}
