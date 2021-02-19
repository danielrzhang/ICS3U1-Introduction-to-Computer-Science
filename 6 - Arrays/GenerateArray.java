import java.util.Scanner;
public class GenerateArray {
	public static double [] generateArray (int noOfElements, double lower, double upper) {
		double [] newList = new double [noOfElements];
		for (int index = 0; index < noOfElements; index++) {
			newList[index] = Math.random() * (upper - lower) + lower;
		}
		return newList;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter the number of elements in the array: ");
		int elements = in.nextInt();
		System.out.print("Enter the lowest ranging number here: ");
		double lower = in.nextDouble();
		System.out.print("Enter the highest ranging number here: ");
		double higher = in.nextDouble();
		double [] array = generateArray(elements, lower, higher);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}


