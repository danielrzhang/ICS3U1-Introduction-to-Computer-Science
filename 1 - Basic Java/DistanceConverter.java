/** Converts a distance in centimeters to imperial units
 * Daniel Zhang
 * February 14, 2020
 */

import java.util.Scanner;
public class DistanceConverter {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a distance in centimeters: ");
		int centimeters = in.nextInt();

		int CentimetersToInches = (int) Math.floor(centimeters / 2.54); // Converts centimeters to inches

		int NumberOfMiles = CentimetersToInches / 63360; // Finds number of miles
		int NumberOfYards = (CentimetersToInches % 63360) / 36; // Finds number of yards
		int NumberOfFeet = ((CentimetersToInches % 63360) % 36) / 12; // Finds number of feet
		int NumberOfInches = CentimetersToInches - (NumberOfMiles * 63360) - (NumberOfYards * 36) - (NumberOfFeet * 12); // Finds number of inches

		System.out.println(NumberOfMiles + " mile(s), " + NumberOfYards + " yard(s), " + NumberOfFeet + " foo(ee)t, " + NumberOfInches + " inch(es)");


	}
}
