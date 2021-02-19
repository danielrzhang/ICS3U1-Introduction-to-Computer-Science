import java.util.Scanner;
public class OutlineRectangle {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the height of the rectangle here: ");
		int width = in.nextInt();
		System.out.print("Enter the width of the rectangle hered: ");
		int length = in.nextInt();

		// Printing top row of asterisks
		for (int i = 0; i < length; i++) {
			System.out.print("*");
		}
		System.out.println();

		// Middle Sections *     * (height - 2) because of top and bottom rows, and (width - 2) for spaces between side *s
		// 1 row only, before moving onto next line
		for (int j = 0; j < (width - 2); j++) {
			for (int k = 0; k < 1; k++) {
				System.out.print("*");
			}

			for (int l = 0; l < (length - 2); l++) {
				System.out.print(" ");
			}

			for (int m = 0; m < 1; m++) {
				System.out.print("*");
			}

			System.out.println();
		}

		// Printing bottom row of asterisks
		for (int i = 0; i < length; i++) {
			System.out.print("*");
		}
		System.out.println();

	}
}