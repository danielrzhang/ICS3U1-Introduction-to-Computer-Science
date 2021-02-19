import java.util.Scanner;
public class StringTwo {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		String name = "Jim Nasium";
		String address = "123 Main Street";

		boolean equal = name.equals(address); // Checks if the two strings are equal, returns boolean
		System.out.println(equal);

		boolean equals = name.equalsIgnoreCase(address); // checks if the two strings are equal ignoring case, returns boolean
		System.out.println(equals);

		int compare = name.compareTo(address); // Checks for ASCII difference, difference until mismatched characters is reached
		System.out.println(compare);

		String sentence1 = "This is a sentence."; // Determines the length of the string
		System.out.println(sentence1.length());

		String sentence2 = "abcdefgh";
		System.out.println(sentence2.charAt(3)); // Finds character in string given index

		String sentence3 = "Count the number of spaces in this string"; // Uses loop to run through string to check spaces
		int spaceCount = 0;
		for (int i = 0; i < sentence3.length(); i++) {
			if (sentence3.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		System.out.println("There are " + spaceCount + " spaces.");

		String str = "abcedfgh";
		String newStr1 = str.substring(3); // Gets index 3 to end of string
		String newStr2 = str.substring(1, 3); // Gets index 1 to 3 (exclusive) of string
		String newStr3 = str.substring(0, 3); // Gets index 0 to 3 (exclusive) of string
		String newStr4 = str.substring(1, 4); // Gets index 1 to 4 (exclusive) of string
		String newStr5 = str.substring(0, 3) + str.substring(6); // Gets index 0 to 3 (exclusive) of string, gets 6 to end of string, and concatenates them together

		System.out.println(newStr1);
		System.out.println(newStr2);
		System.out.println(newStr3);
		System.out.println(newStr4);
		System.out.println(newStr5);

		String fruits = "apple orange pineapple kiwi";
		int findPos1 = fruits.indexOf('p');
		int findPos2 = fruits.indexOf('p', 5);
		System.out.println(findPos1);
		System.out.println(findPos2);







	}
}