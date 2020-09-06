package whileStuff;

public class Factorial {

	public static void main(String[] args) {
		
		factorial(3);
	}
	static int factorial(int max){
		int output=1;
		int counter=1;
		while(counter<=max)
		{
			System.out.println(output*=counter);
			counter++;
		}
		return counter;
	}

}
