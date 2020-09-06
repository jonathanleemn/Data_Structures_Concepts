package forLoops;

public class WhileToFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//While and for loops are similar
		//You can have a while loop do the same thing as a for loop.  
		int count=0;
		System.out.println("While loop!");
		while(count<10){
			System.out.println(count+1);
			count++;
		}
		
		System.out.println();
		System.out.println("For loop!");
		for(int count1=0; count1<10; count1++)
			System.out.println(count1+1);

	}

}
