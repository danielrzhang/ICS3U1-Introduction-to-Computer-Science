/** Determines the type of triangle
 * Daniel Zhang
 * February 19, 2020
 */

import java.util.Scanner;
public class TriangleType {
	public static void main (String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("Enter one side of the triangle: ");
		int firstSide = in.nextInt();
		System.out.print("Enter the second side of the triangle: ");
		int secondSide = in.nextInt();
		System.out.print("Enter the third side of the triangle: ");
		int thirdSide = in.nextInt();
		String firstTriangleType = "";
		String secondTriangleType = "";

		if (firstSide + secondSide > thirdSide || secondSide + thirdSide > firstSide || thirdSide + firstSide > secondSide) {
			if (firstSide == secondSide && secondSide == thirdSide && thirdSide == firstSide) {
				firstTriangleType = "Equilateral";
			}

			else if (firstSide == secondSide || secondSide == thirdSide || thirdSide == firstSide) {
				firstTriangleType = "Isosceles";
				if (Math.pow(firstSide, 2) + Math.pow(secondSide, 2) == Math.pow(thirdSide, 2) || Math.pow(secondSide, 2) + Math.pow(thirdSide, 2) == Math.pow(firstSide, 2) || Math.pow(thirdSide, 2) + Math.pow(firstSide, 2) == Math.pow(secondSide, 2)) {
					secondTriangleType = " Right-angle";
				}
			}

			else {
				firstTriangleType = "Scalene";
				if (Math.pow(firstSide, 2) + Math.pow(secondSide, 2) == Math.pow(thirdSide, 2) || Math.pow(secondSide, 2) + Math.pow(thirdSide, 2) == Math.pow(firstSide, 2) || Math.pow(thirdSide, 2) + Math.pow(firstSide, 2) == Math.pow(secondSide, 2)) {
					secondTriangleType = " Right-angle";
				}
			}
		}

		else {
			firstTriangleType = "Undefined";
		}

		System.out.println("This triangle is a(n) " + firstTriangleType + secondTriangleType + " Triangle");
	}
}


