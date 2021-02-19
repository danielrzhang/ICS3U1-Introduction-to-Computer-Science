import java.util.Arrays;
import java.util.Scanner;
public class ConcertSeats {
	public static void clearSeats (boolean [][] seatsSold) {
		for (int i = 0; i < seatsSold.length; i++) {
			for (int j = 0; j < seatsSold[i].length; j++) {
				seatsSold[i][j] = false;
			}
		}
	}

	public static int bestRowAvailable (boolean [][] seatsSold, int noOfTickets) {
		int counter = 0;

		for (int i = 0; i < seatsSold.length; i++) {
			for (int j = 0; j < seatsSold[i].length; j++) {
				boolean seat = seatsSold[i][j];
				if (seat == true) {
					counter = 0;
					continue;
				}

				else {
					counter++;
					if (counter == noOfTickets) {
						return i + 1;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		boolean [][] theatre = new boolean [10][10];

		do {
			System.out.print("Do you want to buy a single ticket (Y/N)? ");
			char ch = in.next().toUpperCase().charAt(0);

			while (ch != 'N' && ch != 'Y') {
				System.out.print("Invalid Entry! Enter Y or N.");
				ch = in.next().toUpperCase().charAt(0);
			}
			in.nextLine();

			if (ch == 'Y') {
				System.out.print("What row would you like your seat in? ");
				int row = in.nextInt();
				System.out.print("What column would you like your seat in? ");
				int column = in.nextInt();

				theatre[row - 1][column - 1] = true;
			}

			else {
				System.out.print("How many seats in a row would you like to buy? ");
				int noOfTickets = in.nextInt();
				int row = bestRowAvailable(theatre, noOfTickets);
				System.out.println(row);
			}

			for (int i = 0; i < theatre.length; i++) {
				System.out.println(Arrays.toString(theatre[i]));
			}
		} while (true);
	}
}

