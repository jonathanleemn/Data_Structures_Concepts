
public class ArrayBasics2
{
	public static void main(String[] args)
	{
		int num = 1, sum = 0;
		// initialization list will declare, instantiate and initialize values
		// in one line
		// this is useful when you have a small set of data
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// use enhanced for to access the values of an array and make basic
		// calculations.
		for (int nums : arr1)
		{
			System.out.printf("Element %d + 15 is: %d\n", num, nums + 15);
			num++;
		}

		System.out.println();

		// use enhanced for to access the values of an array and sum the values
		for (int nums : arr1)
			sum += nums;
		System.out.printf("The sum of the values in the array is: %d\n", sum);
		System.out.println();

		// calculate values to store in an array
		for (int i = 0; i < arr1.length; i++)
		{
			arr1[i] = 15 * i + 2;
		}
		for (int i = 0; i < arr1.length; i++)
			System.out.printf("Element %d is: %d\n", i, arr1[i]);

	}
}
