import java.util.Scanner;
public class FindOddNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("Enter starting number: ");
		int firstNum = in.nextInt();
		System.out.print("Enter ending number: ");
		int secondNum = in.nextInt();

		int oddCounter = 0;
		int oddTotal = 0;


		for (int i = firstNum; i <= secondNum; i++) {
			if (i % 2 == 1) {
				oddCounter++;
				oddTotal += i;
			}
		}

		System.out.println("There are " + oddCounter + " odd numbers between " + firstNum + " to " + secondNum);
		System.out.println("The sum of odd numbers from " + firstNum + " to " + secondNum + " is " + oddTotal);

	}
}