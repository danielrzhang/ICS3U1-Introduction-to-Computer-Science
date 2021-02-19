import java.util.Scanner;
public class SquaresAndCubes {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.printf("%25s%n", "Squares and Cubes");
		System.out.printf("%s%12s%13s%n", "Number", "Square", "Cube");

		for (int i = 1; i <= 15; i++) {
			int oneNum = i;
			int twoNum = (int) (Math.pow(i, 2));
			int threeNum = (int) (Math.pow(i, 3));

			System.out.printf("%4d%12d%14d%n", oneNum, twoNum, threeNum);
		}
	}
}
