package StaticMethodsFields;

public class StaticPractice {
	private static int totalMethodCalls;

	//sum all digits between 0 and n
	public static int sumDigits(int input){ //static methods should be reserved to things that are standalone procedures that can be done at any time
		int sum=0;
		for(int i=0; i<=input; i++)
			sum+=i;
		totalMethodCalls++;
		return sum;
	}
	
	//calculate factorial
	public static int factorial(int input){
		int factorial=1;
		if(input==0)
			factorial=1;
		else{
			for(int i=1; i<=input; i++)
				factorial*=i;
		}
		totalMethodCalls++;
		return factorial;
		
	}
	
	public static String reversString(String input){
		String reversed="";		
		//string concatenation!
		for(int i=input.length()-1; i>=0; i--){			
			reversed+=input.charAt(i);			
		}
		totalMethodCalls++;
		return reversed;
	}

	//Static methods can only access static data.  They are tied to the class and not an object.
	public static int getTotalMethodCalls() {
		return totalMethodCalls;
	}

	public static void setTotalMethodCalls(int input) {
		totalMethodCalls = input;
	}

}
