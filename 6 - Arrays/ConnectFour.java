/* This is a two-player game for Connect Four. The first player to connect at least 4 tokens wins. This program is user-friendly and can take a variety of input.
 * Daniel Zhang
 * April 22, 2020
 */

import java.util.Arrays;
import java.util.Scanner;
public class ConnectFour {

	/* Method to clear the board (set all the positions to 0)
	 * @param the filled out game board
	 */

	public static void clearBoard (int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0; // Each element in the 2D array is set to 0 (Empty)
			}
		}
	}

	/* Method to determine the row that the player's piece was placed in
	 * @param the game board, the column that the user entered, and the token piece of the player (1 or -1)
	 * @return the row that the piece was placed in. If there is no valid spot, the method returns -1
	 */
	public static int findRow (int [][] board, int column, int player) {
		column--;
		for (int i = board.length - 1; i >= 0; i--) { // This loop checks from the bottom of the column to the top
			if (board[i][column] == 0) { // If the spot is empty, the player's piece is placed in the empty spot
				board[i][column] = player;
				return i + 1;
			}
		}
		return -1;
	}

	/* Method to check for the winner horizontally, vertically, and diagonally
	 * @param the game board, the last row, and the last column that the current piece is in
	 * @return the status of the user, if BLACK or RED won, or EMPTY
	 */
	public static String checkForWinner (int [][] board, int lastRow, int lastColumn) {
		lastRow--;
		lastColumn--;
		int player = board[lastRow][lastColumn]; // Finds the piece of the current player
		int horizontalCounter = 0; // Set counter for horizontal check
		int verticalCounter = 0; // Set counter for vertical check
		int topLeftToBottomRightCounter = 0; // Set counter
		int bottomLeftToTopRightCounter = 0;
		int copyRow = lastRow;
		int copyColumn = lastColumn;

		// Horizontal Combination
		while (lastColumn >= 0) { // Loop runs while the column index does not exceed the left side
			if (board[lastRow][lastColumn] == player) { // Checks the piece to the left. If it is equal to the current piece, add one to the counter
				horizontalCounter++;
				lastColumn--; // Move to the next piece on the left
			}
			else
				break;
		}
		lastColumn = copyColumn + 1; // Resets to the piece one spot to the right of the original piece
		while (lastColumn <= board[lastRow].length - 1) { // Loop runs while the column index does not exceed the right side
			if (board[lastRow][lastColumn] == player) { // Checks the piece to the right. If it is equal to the current piece, add one to the counter
				horizontalCounter++;
				lastColumn++; // Move to the next piece on the right
			}
			else
				break;
		}

		// Vertical Combination
		lastColumn = copyColumn; // Resets to the original piece's column
		while (lastRow >= 0) { // Loop runs while the row index does not exceed the top side
			if (board[lastRow][lastColumn] == player) { // Checks the piece above. If it is equal to the current piece, add one to the counter
				verticalCounter++;
				lastRow--; // Move to the next piece above
			}
			else
				break;
		}
		lastRow = copyRow + 1; // Resets to the piece below the original piece.
		while (lastRow <= board.length - 1) { // Loop runs while the row index does not exceed the bottom side
			if (board[lastRow][lastColumn] == player) { // Checks the piece below. If it is equal to the current piece, add one to the index
				verticalCounter++;
				lastRow++; // Move to the next piece below
			}
			else
				break;
		}

		// Top Left to the Bottom Right Combination
		lastRow = copyRow; // Resets to the original piece's row
		while (lastRow <= board.length - 1 && lastColumn <= board[lastRow].length - 1) { // Loop runs while the row index does not exceed the right side and the column index does not exceed the bottom side
			if (board[lastRow][lastColumn] == player) {
				topLeftToBottomRightCounter++;
				// Move to the next piece diagonally down and right
				lastRow++;
				lastColumn++;
			}
			else
				break;
		}
		// Resets to the piece diagonally up and to the left of the original piece
		lastRow = copyRow - 1;
		lastColumn = copyColumn - 1;
		while (lastRow >= 0 && lastColumn >= 0) { // Loop runs while the row index does not exceed the top row and the column index does not exceed the left side
			if (board[lastRow][lastColumn] == player) {
				topLeftToBottomRightCounter++;
				// Move to the next piece diagonally up and left
				lastRow--;
				lastColumn--;
			}
			else
				break;
		}

		// Bottom Left to the Top Right Combination
		// Resets to the original row and column
		lastRow = copyRow;
		lastColumn = copyColumn;
		while (lastRow <= board.length - 1 && lastColumn >= 0) { // Loop runs while the row index does not exceed the top side and the column index does not exceed the right side
			if (board[lastRow][lastColumn] == player) {
				bottomLeftToTopRightCounter++;
				// Move to the next piece diagonally up and right
				lastRow++;
				lastColumn--;
			}
			else
				break;
		}
		// Resets to the piece diagonally down and to the left of the piece
		lastRow = copyRow - 1;
		lastColumn = copyColumn + 1;
		while (lastRow >= 0 && lastColumn <= board[lastRow].length - 1) { // Loop runs while the row index does not exceed the bottom side and the column index does not exceed the bottom side
			if (board[lastRow][lastColumn] == player) {
				bottomLeftToTopRightCounter++;
				// Move to the next piece diagonally down and left
				lastRow--;
				lastColumn++;
			}
			else
				break;
		}

		if (horizontalCounter >= 4 || verticalCounter >= 4 || topLeftToBottomRightCounter >= 4 || bottomLeftToTopRightCounter >= 4) { // At least four tokens in a row must have been reached
			if (player == 1)
				return "BLACK WON"; // If the token value is 1, BLACK has won

			else
				return "RED WON"; // If the token value is -1, RED has won
		}
		return "EMPTY"; // Return "EMPTY" if none of the players have won yet
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		final int BLACK = 1;
		final int RED = 2;
		final int EMPTY = 0;
		char inPlay = 'Y';
		int turnCounter = 0; // Keeps track of the number of turns
		int [][] board = new int [6][7]; // Declaration and initialization of the board array

		System.out.println("Welcome to Connect Four!");
		System.out.println("The person with black tokens will start, and the person with red tokens will go after.");
		System.out.println("Players must enter the column they want to drop their piece in, and their piece will go in the bottom-most unoccupied spot.");
		System.out.println("The first person to get at least four tokens in a row (horizontally, vertically, or diagonally) wins.");
		System.out.println("This program is user-friendly and can handle a variety of errors.\n");

		while (inPlay == 'Y') {
			for (int i = 0; i < board.length; i++) {
				System.out.println(Arrays.toString(board[i])); // Print out the board following each turn
			}
			int playerName = 0;
			String playerColour = "";
			int playerTurn = 0;

			if (turnCounter % 2 == 0) { // BLACK must always start the round, if the turn counter is even, it is BLACK's turn
				playerTurn = BLACK;
				playerName = 1;
				playerColour = "BLACK";
			}
			else { // If the turn counter is odd, it is RED's turn
				playerTurn = RED;
				playerName = 2;
				playerColour = "RED";
			}

			System.out.print("Enter the column to place your piece in (Player " + playerName + ", " + playerColour + "): ");
			int column = in.nextInt();
			while (column > 7 || column < 1) { // Error handling: User cannot enter a column less than 1 or greater 7
				System.out.print("Invalid Entry! Enter a number between 1 and 7.");
				column = in.nextInt();
			}

			int rowDrop = findRow(board, column, playerTurn); // Calls the findRow function, checks if the column is valid to put a piece in
			while (rowDrop == -1) { // Error handling: If the method returns -1, user cannot put a piece in that column
				System.out.print(rowDrop + "\nInvalid Entry! Enter a different column.");
				column = in.nextInt();
				rowDrop = findRow(board, column, playerTurn);
			}

			System.out.println("Row of Player " + playerName + " piece: " + rowDrop);

			String ifWon = checkForWinner(board, rowDrop, column); // Calls the checkForWinner method, checks if a player has won yet
			System.out.println("\n" + ifWon);
			turnCounter++; // Adds 1 to the turn counter to track whose turn it is, BLACK or RED

			if (ifWon.equals("BLACK WON") || ifWon.equals("RED WON")) { // Checks if the method has returned "RED WON" or "BLACK WON"
				for (int i = 0; i < board.length; i++) {
					System.out.println(Arrays.toString(board[i]));
				}
				clearBoard(board); // Calls the clearBoard function if the user wishes to play another game
				turnCounter = 0; // Resets the turn counter to 0
				System.out.print("Would you like to play again (Y/N)? ");
				inPlay = in.next().toUpperCase().charAt(0);
				while (inPlay != 'Y' && inPlay != 'N') { // Error handling: User must enter if they want to play again (Y/N)
					System.out.print("Invalid entry! Enter Y or N.");
					inPlay = in.next().toUpperCase().charAt(0);
				}
			}
			in.nextLine();
		}
		System.out.println("Thank you for playing Connect Four!");
	}
}