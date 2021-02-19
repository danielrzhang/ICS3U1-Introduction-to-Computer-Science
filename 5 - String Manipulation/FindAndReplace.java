import java.util.Scanner;
public class FindAndReplace {
	private static String SearchAndReplace(String origStr, String searchStr, String replaceStr) {
		for (int i = searchStr.length(); i < origStr.length() + 1; i++) {
			String check = origStr.substring(i - searchStr.length(), i);
			int beginIndex = i - searchStr.length();
			int endIndex = i;
			if (check.equals(searchStr)) {
				origStr = origStr.substring(0, i - searchStr.length()) + replaceStr + origStr.substring(i);
			}
		}
		return origStr;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String largeString = in.nextLine();
		String originalString = in.nextLine();
		String replaceString = in.nextLine();
		String adjustedString = SearchAndReplace(largeString, originalString, replaceString);

		System.out.println(adjustedString);


	}
}