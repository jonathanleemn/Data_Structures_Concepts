import java.util.Scanner;

public class DivideByZeroNoExceptionHandling
{
	//demonstrates throwing an exception when a divide-by-zero occurs
	public static int quotient(int numerator, int denominator)
	{
		return numerator / denominator;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Plase enter an integer numerator: ");
		int numerator = scanner.nextInt();
		System.out.print("Please enter an integer denominator: ");
		int denominator = scanner.nextInt();
		
		int result = quotient(numerator, denominator);
		System.out.printf("%nResult: %d / %d = %d", numerator, denominator, result);
	}

}
