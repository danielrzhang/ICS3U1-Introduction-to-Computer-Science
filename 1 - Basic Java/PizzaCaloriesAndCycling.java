/** Pizza Calories and Cycling
 * Daniel Zhang
 * February 12, 2020
 */

import java.util.Scanner;

public class PizzaCaloriesAndCycling {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("How many pizza slices did you eat? ");
		int slices = in.nextInt();
		double calories = slices * 355.0;
		int CyclingCalories = 550;
		int hours = (int) Math.floor(calories / CyclingCalories);
		int minutes = (int) Math.round(((calories / CyclingCalories) - hours) * 60);
		System.out.println("You ate " + slices + " slices of pizza containing " + (int) calories + " calories and it will take " + hours + " hours and " + minutes + " minutes of cycling to burn it off.");
	}
}
