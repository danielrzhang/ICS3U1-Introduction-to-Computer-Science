import java.util.Scanner;
public class PerformTasks {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter 'a', a coefficient here: ");
		int aValue = in.nextInt();
		System.out.print("Enter 'b', a coefficient here: ");
		int bValue = in.nextInt();

		System.out.println("The equation is " + aValue + "x + " + bValue + " = 0");

		double result = -1 * (bValue / aValue);
		System.out.printf("The value of x is %.2f.%n", result);
	}
}