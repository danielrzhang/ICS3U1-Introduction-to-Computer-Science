import java.util.Scanner;
public class StringOne {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String enteredPassword;
		do {
			System.out.print("Please enter a password: ");
			enteredPassword = input.next();
		} while (enteredPassword != "opensesame");
	}
}