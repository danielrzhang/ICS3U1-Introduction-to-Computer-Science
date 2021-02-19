import java.util.Scanner;
public class LeapYear {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a year here: ");
		int year = in.nextInt();
		String result;
		if (year % 4 == 0) {
			if (year % 400 == 0) {
				result = "This year is a leap year";
			}

			else if (year % 100 == 0) {
				result = "This year is not a leap year";
			}

			else {
				result = "This year is a leap year";
			}

		}

		else {
			result = "This year is not a leap year";
		}

		System.out.println(result);
	}
}