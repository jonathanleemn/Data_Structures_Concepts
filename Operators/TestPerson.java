import java.util.Scanner;


public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//main method is used to begin execution of every Java application
		Scanner scan=new Scanner(System.in);
		String input;
		Person charlie=new Person("Charlie",38, 190, 75);//instantiation of object
		charlie.printMessage();
		charlie.die();
		System.out.println();
	
		
		System.out.println("enter your hair color:");
		input=scan.next();
		input=scan.nextLine();
		
		System.out.println("enter your first and last names on the same line:");
		input=scan.nextLine();
		
		
		System.out.println(input);
		
		
	}

}
