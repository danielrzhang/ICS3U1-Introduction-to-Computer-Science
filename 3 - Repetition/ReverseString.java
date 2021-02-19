import java.util.Scanner;
public class ReverseString {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String str1 = in.nextLine().toUpperCase();
		String str2 = "";

		for (int i = str1.length() - 1; i >= 0; i--) {
			str2 += str1.charAt(i);
		}

		System.out.println(str2);
	}
}
