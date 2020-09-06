package basics;

import java.util.Scanner;

public class BankingMessy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		double balance=0, withdraw, deposit;
		int numTransactions=0;
		int response=0;
		
		do{
			System.out.println("What type of transaction would you like to make?");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Print Balance");
			response=scan.nextInt();
			while(response>3||response<1){
				System.out.println("Invalid input!");
				
				System.out.println("What type of transaction would you like to make?");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Print Balance");
				response=scan.nextInt();
			}
				
			
			switch(response){
				case 1: 
					System.out.println("Plese enter a deposit amount");
					deposit=scan.nextDouble();
					balance+=deposit;
					break;
				case 2:				
					System.out.println("Plese enter a withdraw amount");
					withdraw=scan.nextDouble();
					while(withdraw<0){
						System.out.println("You may not withdraw a negative amount!");
						System.out.println("Plese enter a withdraw amount");
						withdraw=scan.nextDouble();
					}
					while(balance-withdraw<0){
						System.out.println("Insufficient funds.");
						System.out.println("Plese enter a withdraw amount");
						withdraw=scan.nextDouble();
					}
					balance-=withdraw;
					break;
				case 3:
					System.out.printf("Balance: $%,.2f\n",balance);
					break;
			}//end switch
			
			System.out.println("Would you like to make another transaction? \n1. yes\n0. quit");
			response=scan.nextInt();
			
			
		}while(response!=0);

	}

}
