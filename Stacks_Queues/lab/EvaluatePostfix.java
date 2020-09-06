package lab;

/*
 *Source code: https://courses.cs.washington.edu/courses/cse143/12su/lectures/06-27/programs/Postfix.java
*/
import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix
{

	// Evaluates the given postfix expression string and returns the result.
	// Precondition: expression consists only of integers, +-*/, and spaces in
	// proper postfix format such as "2 3 - 4 *"
	public static int postfixEvaluate(String exp)
	{
		Stack<Integer> s = new Stack<Integer>();
		Scanner tokens = new Scanner(exp);

		while (tokens.hasNext())
		{
			if (tokens.hasNextInt())
			{
				s.push(tokens.nextInt());
			} else
			{
				int num2 = s.pop();
				int num1 = s.pop();
				String op = tokens.next();

				if (op.equals("+"))
				{
					s.push(num1 + num2);
				} else if (op.equals("-"))
				{
					s.push(num1 - num2);
				} else if (op.equals("*"))
				{
					s.push(num1 * num2);
				} else
				{
					s.push(num1 / num2);
				}

				// "+", "-", "*", "/"
			}
		}
		return s.pop();
	}
}