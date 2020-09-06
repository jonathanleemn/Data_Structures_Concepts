package MathClassMethods;

public class MathMethodTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//get the absolute value
		System.out.printf("The absolute value of -134 is: %d\n", Math.abs(-134));
		
		//round up!
		System.out.printf("Round up from 1.098 with Math.ceil() %,.2f\n", Math.ceil(1.098));

		//round down!
		System.out.printf("Round down from 1.098 with Math.floor() %,.2f\n", Math.floor(1.098));
		
		//Find max and min
		System.out.printf("The larger of the two numbers 6 and 3 is %d\n", Math.max(6, 3));
		System.out.printf("The smaller of the two numbers 6 and 3 is %d\n", Math.min(6, 3));
		//pass arithmetic expressions as parameters. 
		System.out.printf("The larger of the two numbers (3*4)/9 and (5-6*22)/3is %d\n", Math.max((3*4)/9, (5-6*22)/3));
		
		//make exponential calculations.
		System.out.printf("2 raised to the 10th power is %,.2f\n", Math.pow(2, 10));
		
		//calculate square roots
		System.out.printf("The square root of the max int value is %,.2f", Math.sqrt(Integer.MAX_VALUE));
	}

}
