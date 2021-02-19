import java.util.Scanner;
public class ThreeLargestNumbers {
	public static void largestNum(int num1, int num2, int num3) {
		int largestNum;
		if (num1 > num2 && num1 > num3) {
			System.out.println("The largest number is " + num1);
		}

		else if (num2 > num3 && num2 > num1) {
			System.out.println("The largest number is " + num2);
		}

		else if (num3 > num2 && num3 > num1) {
			System.out.println("The largest number is " + num3);
		}

		else {
			System.out.println("All three numbers are equal");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int number1 = in.nextInt();
		System.out.print("Enter another number here: ");
		int number2 = in.nextInt();
		System.out.print("Enter another number here: ");
		int number3 = in.nextInt();

		largestNum(number1, number2, number3);
	}
}





