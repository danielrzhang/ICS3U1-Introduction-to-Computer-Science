public class QuestionThree {
	public static void main(String[] args) {
		// Remember print statements produce output
		System.out.println("Simple Trace");
		// Whenever you declare a variable, you need to create Memory
		//Trace
		// a new memory location in your memory trace
		int total = 0;
		int number = 5;
		// Let&#39;s add the number to the total
		total = total + number;
		System.out.printf("%d %d%n", number, total);
		// To add a value to a memory location
		// we can use a += shortcut.
		number += 4;
		total += number;
		System.out.printf("%d %d%n", number, total);
		// To add 1 there is a special shortcut (++)
		//Output
		number++;
		total += number;
		System.out.printf("%d %d%n", number, total);
		// In addition to += and ++ we also have shortcuts
		// for subtracting (-= and --)
		number--;
		total -= number;

		System.out.printf("%d %d%n", number, total);
		// Try to guess what this does
		number /= 2;
		total *= number;
		System.out.printf("%d %d%n", number, total);

		//Memory Trace
		// Try the next section of code on your own
		// Don&#39;t forget to show the memory trace
		System.out.println("Extra practice");
		int first = 5;
		int second = 11;
		first += 3;
		second -= 2;
		System.out.printf("%d, %d%n", first, second);
		first--; //Output
		second++;
		System.out.printf("%d, %d%n", first, second);
		first += second;
		second -= first;
		System.out.printf("%d, %d%n", first, second);
		System.out.println("That's all folks");
	}
}