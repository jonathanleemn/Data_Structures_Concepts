package lectureFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class VariableLengthArgsList {
	
	public static String getFirstChars(String... inputStrings){
		String firstChars ="";
		
		for(String inputs: inputStrings){//it is an iterable list
			firstChars+=inputs.charAt(0);
			firstChars+=" ";
		}
		return firstChars;
		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner scan=new Scanner(System.in);
		String input;
		
		System.out.println(getFirstChars("I", "must", "not", "fear.", "Fear", "is", "the", "mind", "killer."));
		

	}

}
