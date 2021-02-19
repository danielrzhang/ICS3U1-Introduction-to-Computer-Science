import java.util.Scanner;
public class PageSide {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter a page number here: ");
		int pageNumber = in.nextInt();
		boolean leftSide;

		if (pageNumber % 2 == 0) {
			leftSide = true;
		}

		else {
			leftSide = false;
		}

		System.out.println("The variable leftSide is set to " + leftSide);
	}
}
