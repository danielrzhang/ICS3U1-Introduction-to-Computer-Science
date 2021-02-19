import java.util.StringTokenizer;
public class TestingStringTokenizer1 {
	public static void main(String[] args) {
		StringTokenizer phrase = new StringTokenizer("Count the number of words in here");
		System.out.println("There are " + phrase.countTokens() + " words in the string.");

		String equation = "387 + 4.7 * 23.4";
		StringTokenizer parsedEquation = new StringTokenizer (equation, "+-/*()", true);

		while (parsedEquation.hasMoreTokens()) {
			System.out.println(parsedEquation.nextToken().trim());
		}
	}
}