import java.util.Scanner;
public class DisplayArray {
	public static void displayArray (double[] list) {
		for (int index = 0; index < list.length; index++) {
			System.out.printf("%10.2f", list[index]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the number of elements in the list: ");
		int number = in.nextInt();
		double [] list = new double [number];

		for (int i = 0; i < number; i++) {
			System.out.print("Enter a number here: ");
			list[i] = in.nextDouble();
		}
		displayArray(list);
		System.out.println();
	}
}


