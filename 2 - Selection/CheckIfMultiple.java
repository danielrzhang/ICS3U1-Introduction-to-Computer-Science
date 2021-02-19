import java.util.Scanner;
public class CheckIfMultiple {
	public static void main(String[] args) {
		Scanner in  = new Scanner (System.in);

		System.out.print("Enter a number here: ");
		int multiple = in.nextInt();
		System.out.print("Enter another number here: ");
		int number = in.nextInt();
		String result;

		if (number % multiple == 0) {
			result = "The number " + number + " is divisible by " + multiple;
		}

		else {
			result = "The number " + number + " is not divisible by " + multiple;
		}

		System.out.println(result);
	}
}
