import java.util.Scanner;
public class FindPower {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a base here: ");
		int base = in.nextInt();
		System.out.print("Enter a power here: ");
		int exponent = in.nextInt();

		int total = 1;

		for (int i = 0; i < exponent; i++) {
			total *= base;
		}
		System.out.println("The answer is " + total + ".");
	}
}