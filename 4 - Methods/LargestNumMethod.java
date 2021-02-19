import java.util.Scanner;
public class LargestNumMethod {
	public static void largestNum (int num1, int num2, int num3) {
		int largest = 0;
		if (num1 > num2 && num1 > num3) {
			largest = num1;
		}

		else if (num2 > num3 && num2 > num1){
			largest = num2;
		}

		else if (num3 > num2 && num3 > num1) {
			largest = num3;
		}

		else {
			largest = Math.max(num1, num2, num3);
		}

		System.out.println("The largest number is " + largest + ".");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a number here: ");
		int num1 = in.nextInt();
		System.out.print("Enter another number here: ");
		int num2 = in.nextInt();
		System.out.print("Enter one more number here: ");
		int num3 = in.nextInt();

		largestNum(num1, num2, num3);
	}
}