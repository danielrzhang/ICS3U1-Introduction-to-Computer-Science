/** Factoring Trinomial(Quadratic Equation)
 * Daniel Zhang
 * First Edited: February 12, 2020
 * Last Edited: February 19, 2020
 */

import java.util.Scanner;
public class Trinomial {
	public static void main(String[] args) {

		double x1, x2;
		Scanner in = new Scanner (System.in);
		System.out.print("Enter 'a', the first coefficient here: ");
		int a = in.nextInt();
		System.out.print("Enter 'b', the second coefficient here: ");
		int b = in.nextInt();
		System.out.print("Enter 'c', the third constant here: ");
		int c = in.nextInt();

		int discriminant = (int) Math.pow(b, 2) - (4 * a * c);
		String result;

		if (discriminant > 0) {
			result = "The discriminant is " + discriminant + ". There are two real roots.";
			x1 = ((-1 * b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			x2 = ((-1 * b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			System.out.printf("The factors of the trinomial are %f and %f.%n" , x1, x2);
		}

		else if (discriminant == 0) {
			result = "The discriminant is " + discriminant + ". There is one real root.";
			x1 = ((-1 * b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
			System.out.printf("The factor of the trinomial is %f.", x1);

		}

		else {
			result = "The discriminant is " + discriminant + ". There are no real roots.";
			System.out.printf("%s%n", result);
		}


	}
}
