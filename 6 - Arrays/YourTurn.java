import java.util.Arrays;
public class YourTurn {
	public static void main(String[] args) {
		int [] numbers = new int [10];
		for (int i = 0; i < 10; i++) {
			int randNum = (int) (Math.random()*(100 + 100 + 1) - 100);
			numbers[i] = randNum;
		}

		int negativeCounter = 0;
		String largerThan10 = "";


		for (int j = 0; j < numbers.length; j++) {
			int n = numbers[j];
			if (n < 0)
				negativeCounter++;

			if (n > 10)
				largerThan10 += n + " ";
		}

		System.out.println();

		int [] newNumbers = new int [10];

		for (int k = numbers.length - 1; k >= 0; k--) {
			newNumbers[(newNumbers.length - 1) - k] = numbers[k];
		}

		System.out.println("Number of Negative Numbers in Array: " + negativeCounter);
		System.out.println("Numbers Larger than 10 in Array: " + largerThan10);
		System.out.println("Original Array: " + Arrays.toString(numbers));
		System.out.println("Modified Array: " + Arrays.toString(newNumbers));



	}
}