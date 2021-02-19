import java.util.Scanner;
public class IndexOfSubArray {
	public static void indexOfSubArray (int [] list, int [] subList) {
		int index = 0;
		int subIndex = 0;
		boolean notBroken = false;

		for (int i = 0; i < list.length; i++) {
			int element = list[i];
			int subElement = subList[subIndex];

			System.out.println(element + " " + subElement);
			if (element == subElement) {
				index++;
				subIndex++;
				notBroken = true;
			}

			else {
				index++;
				subIndex = 0;
				notBroken = false;
			}
		}
		if (notBroken && subIndex == subList.length)
			System.out.println(index);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int [] firstList = {4, 5, 5, 6, 7, 8, 9, 8, 4, 5};

		int [] firstSubList = {5, 6, 7};
		int [] secondSubList = {8};
		int [] thirdSubList = {4, 6, 8};
		int [] fourthSubList = {4, 5, 6};

		indexOfSubArray(firstList, firstSubList);


	}
}

