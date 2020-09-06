package lab;

import java.util.Scanner;

/*
 * by Mark Hawes, Alain Njipwo, Jonathan Lee, and Zach Albers
 */

public class StackMath
{
	static Program program = new Program();

	public static void main(String[] args)
	{
		program.main();
	}
}

class Program{
	static EvaluateInfix evalInfix = new EvaluateInfix();
	static EvaluatePostfix evalPostfix = new EvaluatePostfix();
	static Infix2Postfix infix = new Infix2Postfix();
	static Postfix2Infix postfix = new Postfix2Infix();
	Scanner scan = new Scanner(System.in);
	String converted;
	boolean infixPostfix;
	
	public void main(){
		arLinkPrompt();
		if(!infixPostfix)
			System.out.println(evalInfix.evaluateInfix(converted));
		else
			System.out.println(evalPostfix.postfixEvaluate(converted));
	}
	
	public void arLinkPrompt(){
		System.out.println("Enter 1 to use Linked Stack or 2 to use Array Stack");
		if(scan.nextInt() == 2)
			infixPostfix(false);
		else
			infixPostfix(true);
	}
	
	public void infixPostfix(boolean linked){
		System.out.println("Enter 1 to convert infix to postfix, or 2 to convert postfix to infix");
		int input = scan.nextInt();
		if(input == 1 && linked)
			converted = infix.convertToPostfixLinked(inputPrompt(true));
		else if(input == 1 && !linked)
			converted = infix.convertToPostfixArray(inputPrompt(true));
		else if(input == 2 && linked)
			converted = postfix.convertLinked(inputPrompt(false));
		else if(input == 2 && !linked)
			converted = postfix.convertArray(inputPrompt(false));
	}
	
	public String inputPrompt(boolean inf){
		String infPost = null;
		if(inf){
			infPost = "infix";
			infixPostfix = false;
		}
		else if(!inf){
			infPost = "post";
			infixPostfix = true;
		}
		System.out.printf("%nEnter your %s%n",infPost);
		String input = scan.nextLine();
		scan.nextLine();
		return input;
	}
}
