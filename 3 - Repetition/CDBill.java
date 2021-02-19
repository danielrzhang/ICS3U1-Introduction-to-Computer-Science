/* Creates a bill for cost of CDs and DVDs
 * Daniel Zhang
 * March 3, 2020;
 */

import java.util.Scanner;
public class CDBill {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		// Declare Beginning Variables
		char createNewBill = 'Y';
		int numCustomers = 1;
		int totalCDSold = 0;
		int totalDVDSold = 0;
		double totalCDSales = 0;
		double totalDVDSales = 0;
		double totalSubtotalBeforeDiscountBeforeTax = 0;
		double totalDiscount = 0;
		double totalSubtotalBeforeTax = 0;
		double totalTax = 0;
		double totalTotal = 0;

		do {
			// Constants for costs, discount, and HST
			final double CD_COST = 13.99;
			final double DVD_COST = 19.99;
			final double DISCOUNT = 0.1;
			final double HST = 0.13;

			double customerCDCost;
			double customerDVDCost;
			double customerSubtotalBeforeDiscountBeforeTax;
			double customerDiscount;
			double customerSubtotalBeforeTax;
			double customerHST;
			double customerTotal;

			// Runs if 'Y' is selected
			if (createNewBill == 'Y') {
				System.out.print("\nHow many CDs do you want to buy? ");
				int numCDs = in.nextInt();
				System.out.print("How many DVDs do you want to buy? ");
				int numDVDs = in.nextInt();
				customerCDCost = numCDs * CD_COST; // Calculates CD Cost
				customerDVDCost = numDVDs * DVD_COST; // Calculates DVD Cost
				customerSubtotalBeforeDiscountBeforeTax = customerCDCost + customerDVDCost; // Calculates Subtotal

				if (numCDs + numDVDs >= 10) {
					customerDiscount = DISCOUNT * customerSubtotalBeforeDiscountBeforeTax; // Added Discount
				}

				else {
					customerDiscount = 0;
				}

				customerSubtotalBeforeTax = customerSubtotalBeforeDiscountBeforeTax - customerDiscount; // Subtotal with discount
				customerHST = HST * customerSubtotalBeforeTax; // Amount of HST
				customerTotal = customerHST + customerSubtotalBeforeTax; // Total amount with HST

				// Prints out total bill information for customer
				System.out.println("Customer " + numCustomers + " receipt");
				System.out.println("Number of CDs purchased: " + numCDs);
				System.out.println("Number of DVDs purchased: " + numDVDs);
				System.out.printf("Cost of CDs purchased: $%.2f%n", customerCDCost);
				System.out.printf("Cost of DVDs purchased: $%.2f%n", customerDVDCost);
				System.out.printf("Subtotal Before Discount: $%.2f%n", customerSubtotalBeforeDiscountBeforeTax);
				System.out.printf("10-Item Discount: -$%.2f%n", customerDiscount);
				System.out.printf("Subtotal After Discount: $%.2f%n", customerSubtotalBeforeTax);
				System.out.printf("HST (13%%): $%.2f%n", customerHST);
				System.out.printf("Total: $%.2f%n", customerTotal);

				// Adds information to the total bill at the end of the day
				numCustomers++;
				totalCDSold += numCDs;
				totalDVDSold += numDVDs;
				totalCDSales += customerCDCost;
				totalDVDSales += customerDVDCost;
				totalSubtotalBeforeDiscountBeforeTax += customerSubtotalBeforeDiscountBeforeTax;
				totalDiscount += customerDiscount;
				totalSubtotalBeforeTax += customerSubtotalBeforeTax;
				totalTax += customerHST;
				totalTotal += customerTotal;
			}

			else {
				System.out.println("\nInvalid Entry! Please enter \'Y\' or \'N\'!");
			}

			// Checks if the user wants to create a new bill
			System.out.print("\nWould you like to create a new bill (Y/N)? ");
			createNewBill = in.next().toUpperCase().charAt(0);

		} while (createNewBill != 'N');

		// Prints out total customers, CDS and DVDs purchased, costs, discounts, HST, and sales for the entire day
		System.out.println("Total Sales for the Day");
		System.out.println("Number of Customers: " + (numCustomers - 1));
		System.out.println("Total Number of CDs Purchased: " + totalCDSold);
		System.out.println("Total Number of DVDs Purchased: " + totalDVDSold);
		System.out.printf("Total Cost of CDs Purchased: $%.2f%n", totalCDSales);
		System.out.printf("Total Cost of DVDs Purchased: $%.2f%n", totalDVDSales);
		System.out.printf("Subtotal Before Discount and Before Tax: $%.2f%n", totalSubtotalBeforeDiscountBeforeTax);
		System.out.printf("Total 10-Item Discounts: -$%.2f%n", totalDiscount);
		System.out.printf("Total Subtotal Before Tax: $%.2f%n", totalSubtotalBeforeTax);
		System.out.printf("Total HST (13%%): $%.2f%n", totalTax);
		System.out.printf("Total Sales for the Day: $%.2f%n", totalTotal);
	}
}






