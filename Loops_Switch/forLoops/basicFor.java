package forLoops;

public class basicFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Parts of the loop header: Control variable is i and it it initialized
		 * to 0 Loop-continuation condition (I call this the conditional
		 * statement) is i<=num Increment the control variable i++ Loop body:
		 * sum+=i uses the compound summation operator and also uses the control
		 * variable. The control variable can be used in calculations in the
		 * loop body. Incrementation is the last thing to execute in the body of
		 * a for loop
		 */
		// print out the sum of numbers 0-num
		int sum = 0, num = 15;
		System.out.println("Count\tSum");
		System.out.println("============");

		for (int i = 0; i <= num; i++) {
			sum += i;// use the control variable in calculations
			System.out.printf("%d\t%d\n", i, sum);
			// incrementation happens at the end of the loop body.
		}

		System.out.println("============");
		System.out.println("Total:\t" + sum);

		// int count = 0; equivalent to the for loop up top
		// while (count <= num) {
		// sum += count;
		// System.out.printf("%d\t%d\n", count, sum);
		// count++;
		// }

	}

}
