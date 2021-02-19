import java.util.Scanner;
public class LettersInCommon {
	public static String lettersInCommon (String str1, String str2) {
		String commonLetters = "";
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				char ch1 = str1.charAt(i);
				char ch2 = str2.charAt(j);
				if (ch1 == ch2 && ch1 != ' ' && ch2 != ' ') {
					commonLetters += ch2;
					break;
				}
			}
		}
		return commonLetters;
	}



	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String thing = in.nextLine().toLowerCase();
		String thing1 = in.nextLine().toLowerCase();
		System.out.println(lettersInCommon(thing, thing1));
	}
}

