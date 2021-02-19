import java.util.Scanner;
public class TimeConversion {
	public static void DayToHours (int days) {
		int dayHours = days * 24;
		System.out.println("There are " + dayHours + " hours.");
	}

	public static void HoursToDays (int hours) {
		int numDays = hours / 24;
		int numHours = hours - (numDays * 24);
		System.out.println("There are " + numDays + " days and " + numHours + " hours.");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("1. Days to Hours");
		System.out.println("2. Hours to Days");
		System.out.print("Enter your choice: ");

		int selection = in.nextInt();

		if (selection == 1) {
			System.out.print("Enter the number of days: ");
			int day = in.nextInt();
			DayToHours(day);
		}

		else if (selection == 2) {
			System.out.print("Enter the number of hours: ");
			int hour = in.nextInt();
			HoursToDays(hour);
		}
	}
}
