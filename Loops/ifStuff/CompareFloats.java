package ifStuff;

public class CompareFloats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a=5.66789, b=5.667894, tolerance=.00001;
		//comparing doubles in Java
		if(Math.abs(a-b)<=tolerance)
			System.out.println("a and b are approximately equal");		
		else
			System.out.println("a and b are not");
		}

	}


