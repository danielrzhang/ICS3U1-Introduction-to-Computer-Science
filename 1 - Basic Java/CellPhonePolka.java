/** Calculates Text Messaging and Phone Rates given number of texts and time on phone
 * Daniel Zhang
 * February 14, 2020
 */

import java.util.Scanner;
public class CellPhonePolka {

	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);

		System.out.print("How many minutes were you on the phone for? ");
		int NumMinutes = in.nextInt();

		System.out.print("How many texts did you make? ");
		int NumTexts = in.nextInt();

		// Constants
		final double MONTHLY_ACCESS = 6.99;

		final double MONTHLY_PLAN_A = 24.99;
		final double PLAN_A_PHONE_RATE = 0.25;
		final double PLAN_A_TEXT_RATE = 0.15;
		final int A_TIME_MINIMUM = 30;
		final int A_TEXT_MINIMUM = 20;

		final double MONTHLY_PLAN_B = 31.99;
		final double PLAN_B_PHONE_RATE = 0.20;
		final double PLAN_B_TEXT_RATE = 0.10;
		final int B_TIME_MINIMUM = 40;
		final int B_TEXT_MINIMUM = 20;

		double PhoneACost = PLAN_A_PHONE_RATE * (NumMinutes - A_TIME_MINIMUM); // Cost of Plan A Time
		double TextACost = PLAN_A_TEXT_RATE * (NumTexts - A_TEXT_MINIMUM); // Cost of Plan A Texts

		double PhoneBCost = PLAN_B_PHONE_RATE * (NumMinutes - B_TIME_MINIMUM); // Cost of Plan B Time
		double TextBCost = PLAN_B_TEXT_RATE * (NumTexts - B_TEXT_MINIMUM); // Cost of Plan B Texts

		double TotalPlanA = MONTHLY_ACCESS + MONTHLY_PLAN_A + PhoneACost + TextACost; // Total Costs for Plan A
		double TotalPlanB = MONTHLY_ACCESS + MONTHLY_PLAN_B + PhoneBCost + TextBCost; // Total Costs for Plan B

		System.out.printf("\nThe Access Fee for both Plan A and Plan B is $%.2f", MONTHLY_ACCESS);

		System.out.printf(".\n\nThe Phone Cost for Plan A is $%.2f" , PhoneACost);

		System.out.printf(".\nThe Phone Cost for Plan B is $%.2f", PhoneBCost);

		System.out.printf(".\n\nThe Text Cost for Plan A is $%.2f", TextACost);

		System.out.printf(".\nThe Text Cost for Plan B is $%.2f", TextBCost);

		System.out.printf(".\n\nThe Total Costs for Plan A is $%.2f", TotalPlanA);

		System.out.printf(".\nThe Total Costs for Plan B is $%.2f", TotalPlanB);

		System.out.println(".");



	}
}