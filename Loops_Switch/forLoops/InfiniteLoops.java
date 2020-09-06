package forLoops;

public class InfiniteLoops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// increment instead of decrement
		for(int i=10; i>0; i++)
			System.out.println(i);
		
		//control variable never reaches end condition
		for(int i=0; i>=0; i++)
			System.out.println(i);
		
		//forget to increment
		int count=0;
		while(count<10)
			System.out.println(count);
	}

}
