/* Calculates Gross Wages, Including Taxes
 * Daniel Zhang
 * February 19, 2020
 */
import java.util.Scanner;
public class ClarksCafe{
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.printf("Enter hours worked: ");
		double hourInput = in.nextInt() * 1.0;
		System.out.printf("Enter hourly rate: ");
		double rateInput = in.nextDouble();
		System.out.printf("Exempt (Y/N)? ");
		char exemptChar = in.next().toUpperCase().charAt(0);

		double overTime;
		double overTimeWages;

		if (hourInput > 40) {
			overTime = hourInput - 40.0;
			overTimeWages = rateInput / 2;
		}

		else {
			overTime = 0;
			overTimeWages = 0.00;
		}

		double grossWages = hourInput * rateInput + overTime * overTimeWages;
		double taxesGrossWages = grossWages * 0.82;

		if (exemptChar == 'Y') {
			System.out.printf("Gross Wages = $ %.2f%n", grossWages);
			System.out.println("NO TAXES DEDUCTED");
		}

		else {
			System.out.printf("Gross Wages = $ %.2f%n", grossWages);
			System.out.printf("Wages after taxes = $ %.2f%n", taxesGrossWages);
		}

	}
}


