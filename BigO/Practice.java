import java.util.Arrays;

public class Practice {

	static int array[] = { 3, 6, 5, 1, 4 };

	static int dora[] = { -3, 6, 5, -1, 4 };

	public static void main(String[] args) {
		System.out.println(Arrays.toString(array));
		findMissingNum(method2(array, array.length));
		sort(dora);
		System.out.println(Arrays.toString(dora));

	}

	public static int[] sort(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	// since there is a O(N) nested inside of O(N) the magnitude is really
	// O(N^2)
	public static int[] method2(int[] array, int n) {
		for (int index = 1; index <= n - 1; index++) // O(N)
			privateMethod2(array[index], array, 0, index - 1);
		return array;
	}

	public static void privateMethod2(int entry, int[] array, int begin, int end) {
		int index;
		for (index = end; (index >= begin) && (entry < array[index]); index--) // O(N)
			array[index + 1] = array[index];
		array[index + 1] = entry;
	}

	public static void findMissingNum(int[] array) {
		int missingNum = 0;

		for (int i = 0; i < array.length; i++) // O(N)
		{
			if (array[i] == i + 1)
				missingNum = array[i] + 1;
		}
		System.out.println("Missing Num: " + missingNum);
	}

	public static void getMissingNum(int a[], int n) {
		int i;
		int total = (n + 1) * (n + 2) / 2;
		int sum = 0;
		for (i = 0; i < n; i++)
			sum += a[i];

		System.out.printf("Total: %d %nSum: %d %nThe missing number is %d", total, sum, (total - sum));
	}

}
/*
 * From best to worst: 
 * O(1) constant 
 * O(logn) logarithmic 
 * O(n) linear 
 * O(nlogn) logarithmic 
 * O(n^2) quadratic 
 * O(n^3) cubic 
 * O(n^m) exponential 
 * O(n!) factorial
 * 
 */
