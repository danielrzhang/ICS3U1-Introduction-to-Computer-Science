/** Sum of Numbers between two input numbers
 * Daniel Zhang
 * @param num1 and num2 are the input parameters
 * @return sum is the sum between the two input numbers inclusive
 */

import java.util.Scanner;
public class FindSumBetween {
	public static int sumOfNumbers(int startNum, int endNum) {
		int counter = 0;
		for (int i = startNum; i <= endNum; i++) {
			counter += i;
		}
		return counter;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int startNumber = in.nextInt();
		System.out.print("Enter a higher number here: ");
		int endNumber = in.nextInt();
		int sum = sumOfNumbers(startNumber, endNumber);
		System.out.println("The sum of the numbers between " + startNumber + " and " + endNumber + " inclusive is " + sum);
	}
}
