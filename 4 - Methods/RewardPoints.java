/** Department Store Program
 * Daniel Zhang
 * March 10, 2020
 * @param Cost of monthly purchases
 */

import java.util.Scanner;
public class RewardPoints {

	public static void Standard (double cost) { // Standard Method for the Standard Membership type
		int numPoints = 0;
		if (cost < 75) { // If the monthly purchase is $75 or less, multiply by 5% to get reward points
			numPoints = (int) (Math.round(cost * 0.05));
		}

		else if (cost >= 75 && cost <= 149.99) { // If the monthly purchase is between $75 and $149.99, multiply by 7.5% to get reward points
			numPoints = (int) (Math.round(cost * 0.075));
		}

		else { // If the monthly purchase is above $150, multiply by 10% to get reward points
			numPoints = (int) (Math.round(cost * 0.1));
		}
		System.out.println("You received " + numPoints + " points for using Standard Membership fee.");
		System.out.printf("Your monthly purchase was $%.2f%n", cost);
	}

	public static void Plus (double cost) {
		int numPoints = 0;
		if (cost < 150) { // If the monthly purchase is below $150, multiply by 6% to get reward points
			numPoints = (int) (Math.round(cost * 0.06));
		}

		else { // If the monthly purchase is above $150, multiply by 13% to get reward points
			numPoints = (int) (Math.round(cost * 0.13));
		}
		System.out.println("You received " + numPoints + " points for using Plus Membership fee.");
		System.out.printf("Your monthly purchase was $%.2f%n", cost);
	}

	public static void Premium (double cost) {
		int numPoints = 0;
		if (cost < 200) { // If the monthly purchase is below $200, multiply by 4% to get reward points
			numPoints = (int) (Math.round(cost * 0.04));
		}

		else { // If the monthly purchase is above $200, multiply by 15% to get reward points
			numPoints = (int) (Math.round(cost * 0.15));
		}
		System.out.println("You received " + numPoints + " points for using Premium Membership fee.");
		System.out.printf("Your monthly purchase was $%.2f%n", cost);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a membership type here: ");
		String membershipType = in.nextLine();
		System.out.print("Enter the total monthly purchase here: ");
		double monthlyPurchase = in.nextDouble();

		if (membershipType.equals("Standard")) { // If the membership type is Standard, use Standard Method
			Standard(monthlyPurchase);
		}

		else if (membershipType.equals("Plus")) { // If the membership type is Plus, use Plus Method
			Plus(monthlyPurchase);
		}

		else if (membershipType.equals("Premium")) { // If the membership type is Premium, use Premium Method
			Premium(monthlyPurchase);
		}
	}
}