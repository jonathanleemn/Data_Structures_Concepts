import java.util.Random;


public class ArrayBasics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand=new Random();
		//Declare and instantiate an array
		int[] myArray=new int[10];
		//Assign values into the array by index
		myArray[0]= rand.nextInt(6)+1;
		myArray[1]= rand.nextInt(6)+1;
		myArray[2]= rand.nextInt(6)+1;
		myArray[3]= rand.nextInt(6)+1;
		myArray[4]= rand.nextInt(6)+1;
		myArray[5]= rand.nextInt(6)+1;
		myArray[6]= rand.nextInt(6)+1;
		myArray[7]= rand.nextInt(6)+1;
		myArray[8]= rand.nextInt(6)+1;
		myArray[9]= rand.nextInt(6)+1;
//		myArray[10]= rand.nextInt(6)+1; not possible

		//this will throw an array out of bounds exception.  
		//Index 10 is the 11th element in the array.
		//myArray[10]= rand.nextInt(6)+1;
		
		//Quicker way of assigning values into an array
		//use the control variable to iterate through each element of the array.
		//IMPORTANT: You need to start with element 0 and finish after array.length-1
		//arrays start counting indices at 0 and end at length-1
		for(int i=0; i<myArray.length; i++)
			myArray[i]=rand.nextInt(6)+1;
		
		//enhanced for or the 'for each loop' to iterate over an array
		//enhanced for loop has no control variable so it is not ideal for this type of situation
		int count=0;
		//enhanced for loop
		for(int random: myArray)
			System.out.printf("Element %d is: %d\n",count++ ,random );
		
		

	}

}
