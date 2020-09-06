package practice;

public class Fibo
{

	public static void main(String[] args)
	{
		System.out.println(fibonacci_Recursive(11));
	}

	public static int fibonacci_Recursive(int n) {
		public static void fibonacci_Recursive(int n) {
			if (n ==0) return 0;
			if (n==1) return 1;
			return fibonacci_Recursive(n-1)+fibonacci_Recursive(n-2);
		}
	}

}
