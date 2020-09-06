package ifStuff;
import java.util.Scanner;


public class Blocks {
	public static void main(String[]args){
		int x, y;
		Scanner scan=new Scanner(System.in);
		x=scan.nextInt();
		y=scan.nextInt();
		
		if(x>y){
			System.out.println("X is greater than Y");
			x*=10;
			System.out.printf("the product of x and 10 is: %d",x);
		}
		else
			System.out.println("X is less than Y");
	}

}
