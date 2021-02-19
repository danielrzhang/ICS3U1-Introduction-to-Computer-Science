/* Program that gets user input for name, asks how many tickets they would like to buy, and draws a lucky number for the raffle. The winner gets half of the money for the ticket sales
 * Daniel Zhang
 * April 14, 2020
 */

import java.util.Scanner;
public class UnitedWay5050Draw {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		double totalMoneyRaised = 0; // Counter to keep track of the total amount of money raised
		int ticketCounter = 0; // Counter to keep track of the number of tickets sold
		String [] buyerList = new String [200]; // String array that keeps track of all of the ticket buyers.

		final double TICKET_PRICE = 0.5; // Constant for the cost of each ticket
		final int MAX_TICKETS = 200;  // Constant for the total amount of tickets available for sale

		System.out.println("Welcome to the United Way 50/50 Draw!");
		System.out.println("This is a user-friendly interface. Enter user's name and number of tickets sold until \"END\" is entered. The program will start ticket draw automatically when it has counted 200 tickets sold.");

		do {
			System.out.print("If no one buys more tickets, please enter \"END\"\nUser's name: ");
			String checkName = in.nextLine();
			// Gets input for the user's name

			if (checkName.toUpperCase().equals("END"))
				// If the user entered "END"
			{
				if (ticketCounter == 0) { // Error handling: number of tickets sold cannot be 0, so "END" is a user mistake
					System.out.println("There is no record of any ticket-buyers yet.");
					System.out.print("If no one buys more tickets, please enter \"END\"\nUser's name: ");
					checkName = in.nextLine();
				}

				else // User confirmed no more ticket-buyers, start the drawing
					break;
			}

			System.out.print("Enter number of tickets bought: ");
			int tickets = in.nextInt(); // Gets input for the number of tickets the user wants to buy

			while (tickets <= 0 || ticketCounter + tickets > 200) {
				if (tickets <= 0) { // Error handling: Number of tickets sold cannot be zero or negative
					System.out.println("Invalid Entry! Must enter 1 or more tickets.");
					System.out.print("Enter number of tickets bought: ");
					tickets = in.nextInt();
				}

				if (ticketCounter + tickets > 200) { // Error handling: User cannot buy more tickets than there are left
					System.out.println("Invalid entry! There are " + (200 - ticketCounter) + " tickets left available for sale.");
					System.out.print("Enter number of tickets bought: ");
					tickets = in.nextInt();
				}
			}
			in.nextLine();

			for (int i = ticketCounter; i < ticketCounter + tickets; i++) { // Adds the user's name to the array, depending on how many tickets they bought, to create a better chance for people who buy more to win
				buyerList[i] = checkName;
			}

			ticketCounter += tickets; // Add number of tickets sold from the current user to the total number of tickets sold
			totalMoneyRaised += tickets * TICKET_PRICE; // Add cost of current tickets sold from the current user to the total cost of tickets sold

			if (ticketCounter == 200) { // If the number of tickets sold is equal to 200, lucky raffle draw automatically starts
				break;
			}

		} while (ticketCounter <= MAX_TICKETS); // Do-while loop runs while the number of tickets sold is less than or equal to the total number of tickets available for sale

		int randNum = (int) (Math.random()*(ticketCounter-1)); // Generate random number index between 0 and ticketCounter - 1

		// Prints out the total number of tickets sold, the total cost of tickets sold, the winning number, the name of the winner, and how much money they won
		System.out.printf("%nUnited Way 50/50 sold %d tickets and raised $%.2f.%n%n", ticketCounter, totalMoneyRaised);
		System.out.println("        Drawings Result");
		System.out.println(" The winning ticket number is " + (randNum + 1) + ".");
		System.out.println("The name of the winner is " + buyerList[randNum] + ".");
		System.out.printf("      %s wins $%.2f.%n", buyerList[randNum], totalMoneyRaised / 2);
	}
}
