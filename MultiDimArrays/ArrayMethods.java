
import java.util.Arrays;

public class ArrayMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ints={1,5,2,7,4,3,7,2,1,8,7,9,0,6};//14 elements
		int[][] twoDints={{1,5,2,7,4,3,7,2,1,8,7,9,0,6},{1,5,2,7,4,3,7,2,1,8,7,9,0,6}};
		int[] arraycopy = new int[ints.length-5];//9 elements
		
		System.out.println("Before the sort:");
		System.out.printf("toString call: %s\n",Arrays.toString(ints));
		
		Arrays.sort(ints);//sort the array static method call to the Arrays class
		System.out.println();
		System.out.println("After the sort:");
		System.out.printf("toString call: %s\n",Arrays.toString(ints));
		System.out.println("====================================================================");
		System.out.println();
		
		//binary search
		System.out.printf("the value 8 is in index %d\n",Arrays.binarySearch(ints, 8));
				
		if(Arrays.binarySearch(ints, 123453)>=0)
			System.out.printf("The value 123453 was found in ints at index %d\n", Arrays.binarySearch(ints, 123453));
		else
			System.out.println("The value 123453 was not found in ints");		
		System.out.println("====================================================================");
		System.out.println();
		
		//copy elements to another array
		//first argument: Array to copy from
		//second argument: starting index in the array that we are going to copy from 
		//third argument:  Array we are copying into
		//fourth argument: Index that we will start copying into
		//fifth argument:  number of elements to copy over
		System.arraycopy(ints, 5,arraycopy,0, ints.length-5);
		System.out.println("Copy elements from ints to arraycopy starting with index 5 of ints");
		System.out.printf("toString call: %s\n",Arrays.toString(arraycopy));
		System.out.println("====================================================================");
		System.out.println();
		
		//Check for equivalence
		System.out.printf("ints %s arraycopy.\n", (Arrays.equals(ints, arraycopy)?"==":"!="));
		System.out.println("====================================================================");
		System.out.println();
		
		//fill an array with a value
		Arrays.fill(ints, 7);
		System.out.printf("toString call: %s",Arrays.toString(ints));
		System.out.println();
		Arrays.fill(ints, 3,10,15);//fill only elements 3-10 with 15
		System.out.printf("toString call: %s\n",Arrays.toString(ints));
		System.out.println("====================================================================");
		System.out.println();
		
		System.out.println("Print out multi-dimensional array using toString():");
		System.out.println(Arrays.toString(twoDints[0])+"\n"+Arrays.toString(twoDints[1]));

		//prints out multi-dimensional arrays
		for(int i = 0; i<twoDints.length; i++)
			System.out.println(Arrays.toString(twoDints[i]));
	}
}
