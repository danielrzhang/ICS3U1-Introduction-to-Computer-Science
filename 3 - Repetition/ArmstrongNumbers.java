public class ArmstrongNumbers {
	public static void main(String[] args) {

		int onesDigit;
		int tensDigit;
		int hundredsDigit;
		int sum;

		for (int i = 1; i <= 500; i++) {
			onesDigit = i % 10;
			tensDigit = ((i - onesDigit) / 10) % 10;
			hundredsDigit = (i - (tensDigit * 10) - onesDigit) / 100;

			sum = (int) (Math.pow(hundredsDigit, 3) + Math.pow(tensDigit, 3) + Math.pow(onesDigit, 3));

			if (i == sum) {
				System.out.println(i);
			}

		}



	}
}
