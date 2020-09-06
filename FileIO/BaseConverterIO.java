
/**
 * Write a description of class BaseConverterIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;

public class BaseConverterIO
{   
    /**
     * Constructor for objects of class BaseConverterIO
     */
    public static void main (String[] args) throws IOException
    {
        //overloading constructor to take in no parameters
        //instance of polymorphism b/c it has a is-a relationship
        //binary, octal, and hexadecimal all inherit from Numbers         
    	Numbers binary = new Binary();
        Numbers octal = new Octal();
        Numbers hexadecimal = new Hexadecimal();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 for Binary, 2 for Octal, 3 for Hexadecimal");
        int userInput = scan.nextInt();
        while(userInput != 1 && userInput != 2 && userInput != 3)
        {
            System.out.println("Invalid input");
            System.out.println("Enter 1 for Binary, 2 for Octal, 3 for Hexadecimal");
            userInput = scan.nextInt();
        }
        //method overloading
        //these all use the abstract method convertNum() but each class converts the files differently
        if(userInput == 1)
            binary.convertNum();
        else if(userInput == 2)
            octal.convertNum();
        else if(userInput == 3)
            hexadecimal.convertNum();
    }    
}

abstract class Numbers implements NumTraits
{
    private int number;    
    public Numbers(int num)
    {
        this.number = num;
    }

    public Numbers()
    {
    }

    //getter for number
    public int getNumber()
    {
        return number;
    }

    //setter for number
    public void setNumber(int number)
    {
        this.number = number;
    }
}

//abstract method that can be overridden by other classes
//the binary, octal, and hexadecimal classes will utilize this abstract method
//for converting the files but they will all override it differently
//an example of composition because it has a has-a relationship w/ the sub classes
interface NumTraits
{
    public abstract void convertNum() throws IOException;
}

class Binary extends Numbers
{
    static BufferedReader input;
    static BufferedWriter output;
    static String line;
    /**
     * Constructor for objects of class Binary
     */
    public Binary() throws IOException
    //public static void main (String[] args) throws IOException 
    {
        input = new BufferedReader(new FileReader("SPY.csv"));
        output = new BufferedWriter(new FileWriter("SPYbase2.txt"));
    } 

    //used to override the interface
    @Override
    public void convertNum() throws IOException
    {
        while ((line = input.readLine()) != null) 
        {
            String[] fields = line.split(",");
            output.write(fields[0] + "\t" + Integer.toBinaryString(Integer.parseInt(fields[5])) + "\t" + 
                Long.toBinaryString((long) Double.parseDouble(fields[6])));
            output.newLine();
        }
        input.close();
        output.close();
    }
}

class Octal extends Numbers
{
    static BufferedReader input;
    static BufferedWriter output;
    static String line;

    /**
     * Constructor for objects of class Octal
     */ 
    public Octal() throws IOException
    //public static void main (String[] args) throws IOException 
    {
        input = new BufferedReader(new FileReader("SPY.csv"));
        output = new BufferedWriter(new FileWriter("SPYbase8.txt"));
    } 

    //used to override the interface
    @Override
    public void convertNum() throws IOException
    {
        while ((line = input.readLine()) != null) 
        {
            String[] fields = line.split(",");
            output.write(fields[0] + "\t" + Integer.toOctalString(Integer.parseInt(fields[5])) + "\t" + 
                Long.toOctalString((long) Double.parseDouble(fields[6])));
            output.newLine();
        }
        input.close();
        output.close();
    }
}

class Hexadecimal extends Numbers
{
    static BufferedReader input;
    static BufferedWriter output;
    static String line;
    /**
     * Constructor for objects of class Hexadecimal
     */ 
    public Hexadecimal() throws IOException
    //public static void main (String[] args) throws IOException 
    {
        input = new BufferedReader(new FileReader("SPY.csv"));
        output = new BufferedWriter(new FileWriter("SPYbase16.txt"));
    } 

    //used to override interface 
    @Override
    public void convertNum() throws IOException
    {
        while ((line = input.readLine()) != null) 
        {
            String[] fields = line.split(",");
            output.write(fields[0] + "\t" + Integer.toHexString(Integer.parseInt(fields[5])) + "\t" + 
                Long.toHexString((long) Double.parseDouble(fields[6])));
            output.newLine();
        }
        input.close();
        output.close();
    }
}