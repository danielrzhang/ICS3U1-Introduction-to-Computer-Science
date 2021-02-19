import java.util.Scanner;
public class IfPrime {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		while (true) {
			System.out.print("Enter an integer: ");
			int number = in.nextInt();
			int squareRoot = (int) (Math.sqrt(number)) + 1;
			String result = "";

			for (int i = 2; i < squareRoot; i++) {
				if (number % i != 0) {
					result = "Prime";
				}

				else {
					result = "Not a prime";
					break;
				}
			}

			System.out.println(result);
		}
	}
}
