import java.util.Scanner;
public class SIN {
	public static boolean isValidSIN (String socialInsuranceNumber) {
		int total = 0;
		boolean valid = false;
		for (int i = 1; i < socialInsuranceNumber.length(); i += 2) {
			int secondDigit = Integer.parseInt(String.valueOf(socialInsuranceNumber.charAt(i))) * 2;
			while (secondDigit > 0) {
				int remainder = secondDigit % 10;
				total += remainder;
				secondDigit /= 10;
			}
		}

		for (int j = 0; j < socialInsuranceNumber.length(); j += 2) {
			int firstDigit = Integer.parseInt(String.valueOf(socialInsuranceNumber.charAt(j)));
			total += firstDigit;
		}

		if (total % 10 == 0) {
			valid = true;
		}

		else {
			valid = false;
		}

		return valid;
	}

	public static String addCheckDigit (String partialSIN) {
		int total = 0;
		for (int i = 1; i < partialSIN.length() - 1; i += 2) {
			int secondDigit = Integer.parseInt(String.valueOf(partialSIN.charAt(i))) * 2;
			while (secondDigit > 0) {
				int remainder = secondDigit % 10;
				total += remainder;
				secondDigit /= 10;
			}
		}

		for (int j = 0; j < partialSIN.length() - 1; j += 2) {
			int firstDigit = Integer.parseInt(String.valueOf(partialSIN.charAt(j)));
			total += firstDigit;
		}
		int nearestTenth = (int) (Math.ceil(total / 10.0)) * 10;
		String correctCheck = Integer.toString(nearestTenth - total);
		String correctSIN = partialSIN.substring(0, 8) + correctCheck;

		return correctSIN;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String number = in.nextLine();
		boolean validSIN = isValidSIN(number);
		String correctSIN = addCheckDigit(number);
		System.out.println("Valid SIN: " + validSIN);
		System.out.println("The correct SIN should be " + correctSIN);
	}
}

