package ifStuff;

import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Nesting statements
		System.out.println("Please enter a grade");
		int grade = scan.nextInt();

		if (grade > 100 || grade < 0) {
			System.out.println("Invalid input");
		} else if (grade >= 90) {
			System.out.println("A");
		} else if (grade >= 80) {
			System.out.println("B");
		} else if (grade >= 70) {
			System.out.println("C");
		} else if (grade >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

	}

}
