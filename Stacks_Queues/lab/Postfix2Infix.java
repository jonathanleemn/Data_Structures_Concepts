package lab;
/*
 * Author: Nirupam Das
 * https://javaingrab.blogspot.com/2014/07/postfix-to-infix-conversion-using-stack.html
 */
import java.util.Stack;

public class Postfix2Infix
{

	/**
	 * Checks if the input is operator or not
	 * 
	 * @param c
	 *            input to be checked
	 * @return true if operator
	 */
	private boolean isOperator(char c)
	{
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	/**
	 * Converts any postfix to infix
	 * 
	 * @param postfix
	 *            String expression to be converted
	 * @return String infix expression produced
	 */
	public String convertArray(String postfix)
	{
		StackInterface<String> s = new ArrayStack<>();

		for (int i = 0; i < postfix.length(); i++)
		{
			char c = postfix.charAt(i);
			if (isOperator(c))
			{
				String b = s.pop();
				String a = s.pop();
				s.push("(" + a + c + b + ")");
			} else
				s.push("" + c);
		}

		return s.pop();
	}
	
	public String convertLinked(String postfix)
	{
		StackInterface<String> s = new LinkedStack<>();

		for (int i = 0; i < postfix.length(); i++)
		{
			char c = postfix.charAt(i);
			if (isOperator(c))
			{
				String b = s.pop();
				String a = s.pop();
				s.push("(" + a + c + b + ")");
			} else
				s.push("" + c);
		}

		return s.pop();
	}
}