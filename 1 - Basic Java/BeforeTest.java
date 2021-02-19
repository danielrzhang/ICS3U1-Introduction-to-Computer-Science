public class BeforeTest {
	public static void main(String[] args) {
		int intVar;
		double doubleVar;
		char charVar;
		String strVar;

		intVar = doubleVar;
		charVar = intVar;
		strVar = doubleVar;
		strVar = charVar;
		intVar = (int) doubleVar;
		doubleVar = intVar;
		charVar = doubleVar;
		doubleVar = charVar;
		charVar = strVar;
		doubleVar = (double) strVar;
	}
}
