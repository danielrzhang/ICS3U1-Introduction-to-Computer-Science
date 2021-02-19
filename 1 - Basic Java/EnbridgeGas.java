import java.util.Scanner;

public class EnbridgeGas {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("What is your name? ");
		String name = in.nextLine();

		System.out.print("What is the current month? ");
		String monthName = in.nextLine();

		System.out.print("How many cubic metres of gas did you use this month? ");
		int monthInput = in.nextInt();

		final double FIXED_CHARGE = 19.250;

		double gasDeliveryCharge = 0.133452 * (monthInput);
		double gasSupplyCharge = 0.17303 * (monthInput);

		double subtotal = FIXED_CHARGE + gasDeliveryCharge + gasSupplyCharge;

		double hst = 0.13 * subtotal;

		final double total = subtotal + hst;

		System.out.println("================================");
		System.out.println("Name of Customer: " + name);
		System.out.println("Month: " + monthName);
		System.out.println("Gas Used (Cubic Metres): " + monthInput);
		System.out.println("\nFixed Delivery Charge   $" + FIXED_CHARGE);
		System.out.printf("Gas Delivery Charge   $%.3f", gasDeliveryCharge);
		System.out.printf("\nGas Supply Charge     $%.3f", gasSupplyCharge);
		System.out.println("\n                    +___________");
		System.out.printf("Subtotal              $%.3f", subtotal);
		System.out.printf("\nHST                    $%.3f", hst);
		System.out.println("\n                    +___________");
		System.out.printf("Total                  %.3f",total);
		System.out.println("\n================================");

	}
}