import java.util.Scanner;
public class AverageArray {
	public static double averageOfArray (double[] list) {
		double sumOfList = 0;
		for (int index = 0; index < list.length; index++) {
			sumOfList += list[index];
		}

		return sumOfList / list.length;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the number of elements in the array: ");
		int elements = in.nextInt();
		double [] list = new double [elements];
		for (int i = 0; i < elements; i++) {
			System.out.print("Enter a number: ");
			list[i]  = in.nextDouble();
		}

		double average = averageOfArray(list);
		System.out.println("The average of the numbers in the array is: " + average);
	}
}
