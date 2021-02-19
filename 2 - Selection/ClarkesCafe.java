/* Calculates Gross Wages
 * Daniel Zhang
 * February 19, 2020
 */
import java.util.Scanner;
public class ClarkesCafe{
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.printf("Enter hours worked: ");
		double hourInput = in.nextInt() * 1.0;
		System.out.printf("Enter hourly rate: ");
		double rateInput = in.nextDouble();

		double overTime;
		double overTimeWages;

		if (hourInput > 40) {
			overTime = hourInput - 40;
			overTimeWages = rateInput / 2;
		}

		else {
			overTime = 0;
			overTimeWages = 0.00;
		}

		double grossWages = hourInput * rateInput + overTime * overTimeWages;
		System.out.printf("Gross Wages = $ %.2f%n", grossWages);
	}
}


