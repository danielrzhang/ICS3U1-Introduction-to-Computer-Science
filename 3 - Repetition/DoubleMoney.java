/* Eccentric Millionaire - Find number of days to get a certain amount of money
 * Daniel Zhang
 * March 2, 2020
 */

import java.util.Scanner;
public class DoubleMoney {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the amount of money you want: $");
		double amountMoney = in.nextDouble();

		int counter = 0;
		double start = 0.01;
		double total = 0;

		while (total < amountMoney) {
			total += start;
			start *= 2;
			counter++;
		}

		System.out.printf("It takes %d days to accumulate at least $%.2f%n", counter, amountMoney);
		System.out.printf("After %d days, you will have $%.2f%n", counter, total);
	}
}



