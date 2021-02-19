import java.util.Scanner;
public class LargestThreeNumbers {

	public static void largestNum (int firstNum, int secondNum, int thirdNum) {
		if (firstNum > secondNum && firstNum > thirdNum) {
			System.out.println("The largest number is " + firstNum);
		}

		else if (secondNum > firstNum && secondNum > thirdNum) {
			System.out.println("The largest number is " + secondNum);
		}

		else if (thirdNum > firstNum && thirdNum > secondNum) {
			System.out.println("The largest number is " + thirdNum);
		}

		else {
			System.out.println("All three numbers are the same.");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int num1 = in.nextInt();

		System.out.print("Enter another number here: ");
		int num2 = in.nextInt();

		System.out.print("Enter another number here: ");
		int num3 = in.nextInt();
		largestNum(num1, num2, num3);
	}
}