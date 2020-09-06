package theBasics;

public class Nesting {

	public static void main(String[] args) {
		boolean alternator = true;
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				if (alternator) {
					System.out.print("O ");
				} else {
					System.out.print("+ ");
				}
				alternator = !alternator;
			}
			System.out.println();
		}

		System.out.println();

		for (int row = 1; row < 7; row++) {
			for (int col = 0; col < row; col++) {
				System.out.print("O ");
			}
			System.out.println();
		}
		

	}
}
