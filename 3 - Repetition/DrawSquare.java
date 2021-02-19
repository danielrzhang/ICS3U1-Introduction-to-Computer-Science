import java.util.Scanner;
public class DrawSquare {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the width of the rectangle here: ");
		int width = in.nextInt();
		System.out.print("Enter the length of the rectangle hered: ");
		int length = in.nextInt();

		for (int j = 1; j < width; j++) {
			for (int k = 1; k < length; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}