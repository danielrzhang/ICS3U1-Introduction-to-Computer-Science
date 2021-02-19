import java.util.Scanner;
public class PointDistance {
	public static double distanceBetween (int x1, int y1, int x2, int y2) {
		double result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("Enter the x-coordinate of the first point here: ");
		int x1 = in.nextInt();
		System.out.println("Enter the y-coordinate of the first point here: ");
		int y1 = in.nextInt();
		System.out.println("Enter the x-coordinate of the second point here: ");
		int x2 = in.nextInt();
		System.out.println("Enter the y-coordinate of the second point here: ");
		int y2 = in.nextInt();

		double distance = distanceBetween(x1, y1, x2, y2);
		System.out.printf("The distance between (%d, %d) and (%d, %d) is %.2f%n", x1, y1, x2, y2, distance);
	}
}

