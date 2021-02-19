/* Find the Largest Number
 * Daniel Zhang
 * February 19, 2020
 */

import java.util.Scanner;
public class FindLargestInteger {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("Enter a number: ");
		int firstNum = in.nextInt();
		System.out.print("Enter a second number: ");
		int secondNum = in.nextInt();
		System.out.print("Enter a third number: ");
		int thirdNum = in.nextInt();
		int largestNum;

		if (firstNum < secondNum && thirdNum < secondNum)
			largestNum = secondNum;

		else if (firstNum < thirdNum && secondNum < thirdNum)
			largestNum = thirdNum;

		else
			largestNum = firstNum;

		// Outputs the largest number
		System.out.println("The largest number is " + largestNum + ".");
	}
}

