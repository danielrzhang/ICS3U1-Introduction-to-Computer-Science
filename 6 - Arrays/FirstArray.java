import java.util.Scanner;
public class FirstArray {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int [] marks = new int [10];
		marks[0] = 97;
		marks[1] = 56;
		marks[2] = 34;

		for (int i = 0; i < marks.length; i++) {
			System.out.println(marks[i]);
		}
	}
}