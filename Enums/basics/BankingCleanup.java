package basics;

import java.util.Scanner;

public class BankingCleanup {

	/*
	 * How many distinct tasks are being performed in the main? comment the code
	 * to explain each task being performed, rewrite the class such that it has
	 * no main method and each task is performed by a method. You may have
	 * methods calling methods in their implementation. Set the class up such
	 * that user input is performed by a class with a main method.
	 *
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double balance = 0;
		int numTransactions = 0;
		int response = 0;
		
		
		do {
			// prompts an input between 1-3
			 response = displayUI(scan);

			// when user tries to enter an invalid input
			while (response > 3 || response < 1) {
				System.out.println("Invalid input!");
				 response = displayUI(scan);
			}

			// case 1 = when user selects deposit
			switch (response) 
			{
			case 1:
				makeDeposit(balance, scan);
				break;

			// case 2 = when user selects withdraw
			case 2:
				balance -= makeWithdrawal(scan, balance);
				break;

			// case 3 = prints balance
			case 3:
				System.out.printf("Balance: $%,.2f\n", balance);
				break;
			}// end switch

			System.out.println("Would you like to make another transaction? \n1. yes\n0. quit");
			response = scan.nextInt();

		} while (response != 0);

	}

	public static void makeDeposit(Double val, Scanner scan) 
	{
		System.out.println("Plese enter a deposit amount");
		double deposit = scan.nextDouble();
		
		while (deposit < 0) {
			System.out.println("You may not deposit a negative amount!");
			System.out.println("Plese enter a withdraw amount");
			deposit = scan.nextDouble();
		}
		val += deposit; // adds deposit to balance
	}

	public static double makeWithdrawal(Scanner scan, double balance) 
	{
		System.out.println("Plese enter a withdraw amount");
		double withdraw = scan.nextDouble();

		while (withdraw < 0) {
			System.out.println("You may not withdraw a negative amount!");
			System.out.println("Plese enter a withdraw amount");
			withdraw = scan.nextDouble();
		}
		// if user attempts to withdraw more than what is in the balance
		while (balance - withdraw < 0) {
			System.out.println("Insufficient funds.");
			System.out.println("Plese enter a withdraw amount");
			withdraw = scan.nextDouble();
		}
		return withdraw;
	}
	
	public static int displayUI(Scanner scan){ //response is an int and we're returning it
		System.out.println("What type of transaction would you like to make?");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Print Balance");
		return scan.nextInt();
	}
}
