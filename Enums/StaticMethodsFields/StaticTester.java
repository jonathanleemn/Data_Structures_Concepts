package StaticMethodsFields;

public class StaticTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("The sum of the digits between 0 and 5 is: %d\n", StaticPractice.sumDigits(5));
		System.out.printf("5! is: %d\n", StaticPractice.factorial(5));
		System.out.printf("Hello reversed is: %s\n", StaticPractice.reversString("Hello"));
		System.out.printf("Your total number of method calls is %d", StaticPractice.getTotalMethodCalls());	
	}

}
