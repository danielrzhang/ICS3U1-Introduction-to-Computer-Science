import java.util.Scanner;
public class TemperatureConversion {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		double celsiusTemp, fahrenheitTemp;
		char tryAgain = 'Y';

		do {
			if (tryAgain == 'Y') {
				System.out.print("Enter 1 to convert from degC to degF and enter 2 to convert from degF to degC: ");
				int number = in.nextInt();
				if (number != 1 && number != 2) {
					System.out.println("Invalid entry!");
				}

				else {
					if (number == 1) {
						System.out.print("Enter degC here: ");
						double degC = in.nextDouble();
						double degCToF = (degC * 9 / 5) + 32;
						System.out.printf("%.1f degrees Fahrenheit%n", degCToF);
					}

					else {
						System.out.print("Enter degF here: ");
						double degF = in.nextDouble();
						double degFToC = ((degF - 32) * 5) / 9;
						System.out.printf("%.1f degrees Celsius%n", degFToC);
					}
				}
			}

			else {
				System.out.println("Invalid entry!");
			}

			System.out.println("Do you want to convert again (Y/N)? ");
			tryAgain = in.next().toUpperCase().charAt(0);

		} while (tryAgain != 'N');
		System.out.println("Thank you for using the Temperature Converter.");
	}
}

