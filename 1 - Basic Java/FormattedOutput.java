/**Formatted Output using printf, String and Decimal Formatters
 * Daniel Zhang
 * February 18, 2020
 */

import java.util.Scanner;
public class FormattedOutput {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("Enter the name of a fruit: ");
		String firstFruit = in.nextLine();
		System.out.print("Enter the name of another fruit: ");
		String secondFruit = in.nextLine();
		System.out.print("Enter the name of another fruit: ");
		String thirdFruit = in.nextLine();

		System.out.print("Enter the price of a " + firstFruit + ": ");
		double firstFruitPrice = in.nextDouble();
		System.out.print("Enter the price of a " + secondFruit + ": ");
		double secondFruitPrice = in.nextDouble();
		System.out.print("Enter the price of a " + thirdFruit + ": ");
		double thirdFruitPrice = in.nextDouble();


		System.out.printf("%-10s$%.2f%n", firstFruit, firstFruitPrice);
		System.out.printf("%-10s$%.2f%n", secondFruit, secondFruitPrice);
		System.out.printf("%-10s$%.2f%n", thirdFruit, thirdFruitPrice);


	}
}