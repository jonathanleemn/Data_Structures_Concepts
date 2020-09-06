package ifStuff;

public class DanglingElse {
	public static void main(String[] args) {
		int x = 15, y = 7;
		// this gives us invalid output
		// else statements are tied to the if directly above them
		if (x > 10)
			if (y > 10)
				System.out.println("x and y are greater than 10");
			else
				System.out.println("x <= 10");

		// the second if is in the body of the first if
		if (x > 10) 
		{
			if (y > 10)
				System.out.println("x and y are greater than 10");
		} 
		else
			System.out.println("x <= 10");

	}
}
