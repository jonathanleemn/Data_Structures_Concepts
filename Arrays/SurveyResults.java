
public class SurveyResults {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] responses={1,5,3,5,3,6,3,4,2,3,2,3,5,2,3,2,1,5,5,4,3,2,3,5,4,3,2,3,4,5};
		int[] frequency=new int[6];
		
		/*This program uses two arrays together
		 * The responses array is a series of responses to a survey and 
		 * the frequency array is going to count how often a certain value 
		 * is entered into the responses array.
		 * */
		
		for(int i=0; i<responses.length;i++){//loop over each element in the responses array
			/*
			 * try and catch are used to handle exceptions.  
			 * The try block will attempt to execute some statements.
			 * The catch block will handle any exceptions thrown by the try block
			 * These are used in situations where you expect some problems to arise. 
			 * This will prevent the program from crashing is an exception is thrown. 
			 * */
			try{
				++frequency[responses[i]];//frequency will increment a counter in the appropriate index
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e);
				System.out.printf("\tResponses[%d] = %d\n\n", i, responses[i]);
			}//end catch			
		}//end for
		
		System.out.printf("%s%10s\n", "Rating: ", "Frequency:");
		
		for(int i=1;i<frequency.length;i++)
			System.out.printf("%7d%10d\n", i, frequency[i]);

	}

}
