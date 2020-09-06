import java.util.Random;


public class BarChart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] myArray=new int[6];
		Random rand=new Random();
		
		//use an element of an array as a counter
		//increment a counter in a random index between 1 and 6.  This is like rolling a die.
		for(int i=0; i<500; i++)
			++myArray[rand.nextInt(6)];
		
		for(int i=0; i<6; i++){
			//label for each line of output
			System.out.printf("%d's rolled: ", i+1);
			
			//output the stars.  
			for(int stars=0;stars<myArray[i];stars++){
				System.out.print("*");
			}
			//move to next line of output
			System.out.println();
		}
		
		System.out.println();
		
		//increment a counter in a random index between 1 and 6.  This is like rolling a die.
		//check the frequency of each number rolled over 6000000 rolls.
		for(int i=0; i<6000000; i++)
			myArray[rand.nextInt(6)]++;
		
		System.out.printf("%s%12s\n","Number", "Frequency");
		
		for(int i=0;i<myArray.length;i++)
			System.out.printf("%6d%12d\n", i+1, myArray[i]);
		
		

	}

}
