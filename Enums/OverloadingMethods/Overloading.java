package OverloadingMethods;

public class Overloading {
	//overloading is making multiple methods of the same name
	//but changing the parameter arguments
	//The compiler always knows which method to invoke based upon the values passed
	
	public static int sumDigits(int input){
		int sum=0;
		for(int i=0; i<input; i++)
			sum+=i;
		return sum;		
	}
	
	//this version of sum digits will sum the 4 ints that are passed.
	public static int sumDigits(int in1, int in2, int in3, int in4){		
		return in1+in2+in3+in4;		
	}
	
	//I can't do this.  I cannot define the same method twice
	public static int sumDigits(int input){
		int sum=0;
		for(int i=0; i<input; i++)
			sum+=i;
		return sum;		
	}
	
	//I can't do this.  The compiler does not look at the return type
		public static double sumDigits(int input){
			int sum=0;
			for(int i=0; i<input; i++)
				sum+=i;
			return sum;		
		}
	
	

}
