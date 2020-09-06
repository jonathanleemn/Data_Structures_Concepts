package labs;

//***************************************************************
//StringMutate.java
//
//Test several methods for manipulating String objects
//***************************************************************

/*The file StringMutate.java contains this program. 
 * Save the file to your directory and compile and run it. 
 * Study the output and make sure you understand the relationship 
 * between the code and what is printed. Now modify the file as follows: 

1.	Declare a variable of type String named middle3 
(put your declaration with the other declarations near the top of the program) 
and use an assignment statement and the substring method to assign middle3 
the substring consisting of the middle three characters of phrase 
(the character at the middle index together with the character to the 
left of that and the one to the right – use variables, not the literal 
indices for this particular string). Add a println statement to print out the result. 
Save, compile, and run to test what you have done so far. 


2.	Add an assignment statement to replace all blank characters in switchedPhrase 
with an asterisk (*). The result should be stored back in switchedPhrase 
(so switchedPhrase is actually changed). (Do not add another print—place your statement 
in the program so that this new value of switchedPhrase will be the one printed in the 
current println statement.) Save, compile, and run your program. 

3.	Declare two new variables city and state of type String. Add statements to the 
program to prompt the user to enter their hometown—the city and the state. 
Read in the results using the appropriate Scanner class method – you will need 
to have the user enter city and state on separate lines.  Then using String class 
methods create and print a new string that consists of the state name 
(all in uppercase letters) followed by the city name (all in lowercase letters) 
followed again by the state name (uppercase). So, if the user enters Lilesville 
for the city and North Carolina for the state, the program should create and print 
the string 

NORTH CAROLINAlilesvilleNORTH CAROLINA*/

import java.util.Scanner;

public class StringMutate
{
public static void main (String[] args)
{
String phrase = new String ("This is a String test.");
int phraseLength;   // number of characters in the phrase String
int middleIndex;    // index of the middle character in the String
String firstHalf;   // first half of the phrase String
String secondHalf;  // second half of the phrase String
String switchedPhrase; // a new phrase with original halves switched

// compute the length and middle index of the phrase
phraseLength = phrase.length();
middleIndex = phraseLength / 2;

// get the substring for each half of the phrase
firstHalf = phrase.substring(0,middleIndex);
secondHalf = phrase.substring(middleIndex, phraseLength);

// concatenate the firstHalf at the end of the secondHalf
switchedPhrase = secondHalf.concat(firstHalf);

// print information about the phrase
System.out.println();
System.out.println ("Original phrase: " + phrase);
System.out.println ("Length of the phrase: " + phraseLength +
		    " characters");
System.out.println ("Index of the middle: " + middleIndex);
System.out.println ("Character at the middle index: " + 
		    phrase.charAt(middleIndex));
System.out.println ("Switched phrase: " + switchedPhrase);

System.out.println();
}
}



