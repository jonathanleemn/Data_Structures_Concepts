package labs;

import java.util.Scanner;

public class GuessingGame {
	
	public static void main(String[] args) {
		int num = (int) (Math.random()*100+1);
		int guess=0, count=5;
		boolean isCorrectGuess=false;
		
		Scanner scan=new Scanner(System.in);
		
		while(!isCorrectGuess&&count>0){
			System.out.printf("You have %d guesses left!", count);
			System.out.println("Please guess a number between 1 and 100 inclusive:");
			guess=scan.nextInt();
			
			while(!(guess<=100&&guess>1)){
				System.out.println("Please gues a number between 1 and 100 inclusive:");
				guess=scan.nextInt();
			}	
			count--;
			
			if(guess==num){
				System.out.println("You are correct!");
				isCorrectGuess=true;
			}
			else if(guess<num)
				System.out.println("Your guess was too low!");
			else
				System.out.println("Your guess was too high!");
		}
	}

}
