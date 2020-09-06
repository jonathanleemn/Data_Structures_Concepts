package forLoops;

public class OffByOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// print out numbers through 10
		for (int i = 0; i <= 10; i++)
			System.out.println(i);

		// create an array and fill it with values 0-10
		int[] myArray = new int[10];
		for (int i = 0; i < 10; i++)
			myArray[i] = i;

	}

}
