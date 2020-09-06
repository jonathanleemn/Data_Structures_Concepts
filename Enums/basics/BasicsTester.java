package basics;

import java.io.ObjectInputStream.GetField;

public class BasicsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiArgumentParameter obj=new MultiArgumentParameter();
		obj.average(3, 4, 5);
		System.out.println(obj.getAverageOfThree());
		

	}

}
