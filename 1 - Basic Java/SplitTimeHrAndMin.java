import java.util.Scanner;

public class SplitTimeHrAndMin {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("Please enter the name of the longer song: ");
		String longSong = in.nextLine();

		System.out.print("Please enter the length of the longer song (Min:Sec): ");
		String longHrMin = in.nextLine();

		System.out.print("Please enter the name of the shorter song: ");
		String shortSong = in.nextLine();

		System.out.print("Please enter the length of the shorter song (Min:Sec): ");
		String shortHrMin = in.nextLine();

		String [] longTime = longHrMin.split(":");
		int longMin = Integer.parseInt(longTime[0].trim());
		int longSec = Integer.parseInt(longTime[1].trim());

		String [] shortTime = shortHrMin.split(":");
		int shortMin = Integer.parseInt(shortTime[0].trim());
		int shortSec = Integer.parseInt(shortTime[1].trim());

		int totalLongSec = longMin * 60 + longSec;
		int totalShortSec = shortMin * 60 + shortSec;

		int difference = totalLongSec - totalShortSec;

		final int newMin = difference / 60;

		final int newSec = difference - (newMin * 60);

		System.out.println(longSong + " is " + newMin + ":" + newSec + " longer than " + shortSong + ".");
		System.out.println("Thank you for using the Song Time Difference Calculator.");

	}
}