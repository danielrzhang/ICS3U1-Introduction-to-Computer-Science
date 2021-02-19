/** Input Output Calculations
 * Daniel Zhang
 * February 13, 2020
 */

import java.util.Scanner;
public class AmountOfChange {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the amount of change in dollars: ");

		double change1 = in.nextDouble();
		int change = (int) (change1 * 100);
		System.out.println("Change = " + change);

		int numQuarter = change / 25;
		System.out.println("Number of Quarters = " + numQuarter);

		int numDimes = (change % 25) / 10;
		System.out.println("Number of Dimes = " + numDimes);

		int numNickels = (int) Math.round(((change % 25) % 10) / 5.0);
		System.out.println("Number of Nickels = " + numNickels);

		int total = numNickels + numQuarter + numDimes;

		System.out.println("The minimal number of coins needed to make $" + change1 + " is " + total + " coins.");
	}
}



