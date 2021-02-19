public class RemoveLastNumPrime {
	private static int FindLargestPrime () {
		int maxNum = 0;
		for (int i = 10; i <= Integer.MAX_VALUE; i++) {
			while (i > 10) {
				boolean isPrime = true;
				for (int j = 2; j <= i / 2; i++) {
					maxNum = i;
					System.out.println(maxNum);
					if (i % j != 0 && i != 1) {
						isPrime = true;
						i = (i - (i % 10)) / 10;
					}

					else {
						isPrime = false;
						break;
					}
				}
			}
		}
		return maxNum;
	}

	public static void main(String[] args) {
		int thing = FindLargestPrime();
		System.out.println(thing);
	}


}