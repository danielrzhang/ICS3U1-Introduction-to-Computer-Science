/** Program to remove a chosen number from an array. If the number is found, the first instance of it is removed and the array is returned. Else, the original array is returned
 * Daniel Zhang
 * April 14, 2020
 */

import java.util.Arrays;
import java.util.Scanner;
public class ArrayRemoval {

	/** Method to remove a target number from an array
	 * @param array of integers, and the number that the user wants to remove from the array
	 * @return the original array or array without the target number inside
	 */
	public static int [] removeFromArray (int [] array, int target) {
		int elements = 0; // Initialize the length of the new array
		int breakPoint = 0; // Initialize the index where the target number is found

		for (int i = 0; i < array.length; i++) { // For loop that iterates through all the elements in the array
			if (array[i] == target) {
				elements = array.length - 1; // The new array is set to one less the length of the original
				breakPoint = i; // Break point for array is set
				break;
			}

			else {
				if (i == array.length - 1) // If the target cannot be found, return original array
					return array;
			}
		}

		// The following code removes the matching elements from the original array and copies to the new array without the target number
		int [] newArray = new int [elements];
		for (int i = 0; i <= breakPoint - 1; i++)
			newArray[i] = array[i];

		for (int i = breakPoint + 1; i <= array.length - 1; i++)
			newArray[i - 1] = array[i];
		// End of array copying

		return newArray; // Returns the modified array
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		System.out.print("Do you want to create your own array? If No, the program will create a random array for you. (Y/N)? ");
		char userResponse = in.next().toUpperCase().charAt(0); // Ask user if they want to create their own array. If not, the program randomly generates one

		while (userResponse != 'N' && userResponse != 'Y') {
			System.out.print("Invalid entry! Do you want to create your own array? If No, the program will create a random array for you. (Y/N)? ");
			userResponse = in.next().toUpperCase().charAt(0);
		}

		if (userResponse == 'Y') { // User can make their own arrays with their own elements inside
			System.out.print("Enter the size of the array: ");
			int elements = in.nextInt();
			int [] numbers = new int [elements];

			for (int i = 0; i < elements; i++) { // Runs through array and lets the user add elements to the array
				System.out.print("Enter number" + (i + 1) + ": ");
				int numberInArray = in.nextInt();
				numbers[i] = numberInArray;
			}
			System.out.println(Arrays.toString(numbers)); // Prints out the original array
			System.out.print("Enter the number you want to remove from the array: "); // Asks the user what number they want to remove from array
			int target = in.nextInt();

			int [] newNumbers = removeFromArray(numbers, target); // removeFromArray method is executed, returns the (un)modified array
			System.out.println(Arrays.toString(newNumbers)); // Prints out the modified array
		}

		else {
			int [] numbers = new int [25]; // Randomly generates an array of 25 numbers if the user does not choose to make their own array
			for (int i = 0; i < 25; i++) {
				int randNum = (int) (Math.random()*(100 + 100 + 1) - 100); // Generates 25 numbers between 1 and 100
				numbers[i] = randNum;
			}
			System.out.print("Enter the number you want to remove from the array: ");  // Asks the user what number they want to remove from the array
			int target = in.nextInt();

			int [] newNumbers = removeFromArray(numbers, target); // removeFromArray method is executed, returns the (un)modified array
			System.out.println(Arrays.toString(newNumbers)); // Prints out the modified array
		}
	}
}
