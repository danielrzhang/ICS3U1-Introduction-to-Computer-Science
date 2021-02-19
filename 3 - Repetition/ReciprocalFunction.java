import java.util.Scanner;
public class ReciprocalFunction {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		for (double i = 1; i <= 20; i++) {
			System.out.printf("%.2f, ", 1/i);
		}
		System.out.println();
	}
}