public class ReverseDivisibleSeven {
	public static void main(String[] args) {
		for (int i = 100; i >= 1; i--) {
			if (i % 7 == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println();
	}
}