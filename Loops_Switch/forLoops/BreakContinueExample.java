package forLoops;

import java.util.Random;

public class BreakContinueExample {

	// print out the tens values between 1 and 1000
	public static void main(String[] args) {
		Random rand = new Random();
		int num = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i % 10 != 0)
				continue;
			System.out.println(i);
		}

		for (int i = 0; i <= 1000; i++) {
			if (i % 10 != 0) {
				num = rand.nextInt(10);
				System.out.printf("Count is: %d \tNum is: %d\n", i, num);
			}
			if (num == 8) {
				break;
			}
		}
		

	}

}
