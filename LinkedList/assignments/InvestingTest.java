package assignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Author: Jonathan Lee
 * Course: Structures II - Spring 2017
 * Assignment 3 - Investing program using linkedlist and arraylist
 * 
 * the linkedlist class has an efficiency of n^2 because initLinkedList() contains a while loop containing incrementDate(), which also contains a while loop.
 * the big-o for linkedlist class would be n * n = O(N^2).
 * the big-o for the arraylist class is also O(N^2) because it has a similar structure to the linkedlist class.
 * the big-o for the entire program would be O(N^3) because the driver method also has a loop that contains the two classes listed above.
 * the linkedlist class should be more efficient than the arraylist class because adding and inserting the nodes has an efficieny of O(1),
 * whereas the arraylist's method of adding to each list has an effiency of O(N).
 */


public class InvestingTest
{
	static LinkedListUserAccount LLaccount = new LinkedListUserAccount();
	static ArrayListUserAccount ALaccount = new ArrayListUserAccount();
	static Scanner input = new Scanner(System.in);
	static int listChoice;

	//driver class
	public static void main(String[] args) throws IOException, ParseException
	{
		try
		{
			while (listChoice != 1 || listChoice != 2)
			{
				System.out.print("Enter 1 for LinkedList or 2 for ArrayList: ");
				listChoice = input.nextInt();

				if (listChoice == 1)
					LLaccount.initLinkedList();
				else if (listChoice == 2)
					ALaccount.initArrayList();
				else
					System.out.println("Invalid input detected.");
			}

		} catch (InputMismatchException e)
		{
			System.out.println("Invalid input detected. Please restart program.");
		}
	}
}

// defining what a node is and what it should contain
//used as a basis for the listbuilder class
class Node
{
	private double cashBalance = 1000;
	private double interestRate = .0027;
	private double spyInvestment = 0;
	private int shareBalance = 0;
	private double currentSPYprice;
	private Node next;
	private String date;

	public Node(double cashBal, double intRate, double spyInvest, int shareBal, double currSPYprice)
	{
		this.cashBalance = cashBal;
		this.interestRate = intRate;
		this.spyInvestment = spyInvest;
		this.shareBalance = shareBal;
		this.currentSPYprice = currSPYprice;
	}

	public Node(double cashBal, double intRate, double spyInvest, int shareBal, double currSPYprice, Node next)
	{
		this.cashBalance = cashBal;
		this.interestRate = intRate;
		this.spyInvestment = spyInvest;
		this.shareBalance = shareBal;
		this.currentSPYprice = currSPYprice;
		this.next = next;
	}

	public Node(String date2, double currSPYprice, Node next)
	{
		this.date = date2;
		this.currentSPYprice = currSPYprice;
		this.next = next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node next()
	{
		return next;
	}

	public double getCashBalance()
	{
		return cashBalance;
	}

	public void setCashBalance(double cashBalance)
	{
		this.cashBalance = cashBalance;
	}

	public double getInterestRate()
	{
		return interestRate;
	}

	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}

	public double getSpyInvestment()
	{
		return spyInvestment;
	}

	public void setSpyInvestment(double spyInvestment)
	{
		this.spyInvestment = spyInvestment;
	}

	public int getShareBalance()
	{
		return shareBalance;
	}

	public void setShareBalance(int shareBalance)
	{
		this.shareBalance = shareBalance;
	}

	public double getCurrentSPYprice()
	{
		return currentSPYprice;
	}

	public void setCurrentSPYprice(double currentSPYprice)
	{
		this.currentSPYprice = currentSPYprice;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}
}

//uses the node class to construct a linkedlist
class ListBuilder
{
	private Node head;

	public ListBuilder()
	{
		head = null;
	}

	//retrieves date (in string format) from the first node
	public String getDateNode()
	{
		String date;
		Node place = head;
		date = place.getDate();
		return date;
	}

	//retrieves price (in double format) from the first node
	public double getPriceNode()
	{
		double date;
		Node place = head;
		date = place.getCurrentSPYprice();
		return date;
	}

	//adds a node to the back of the linkedlist
	public void addToBack(double cashBal, double intRate, double spyInvest, int shareBal, double currSPYprice)
	{
		Node current = head;

		if (current == null)
		{
			head = new Node(cashBal, intRate, spyInvest, shareBal, currSPYprice, current);
			head.setNext(null);
		} 
		else
		{
			while (current.next() != null)
			{
				current = current.next();
			}
			// append new node to back
			Node n = new Node(cashBal, intRate, spyInvest, shareBal, currSPYprice, null);
			current.setNext(n);
		}
	}

	//inserts a node at the front of the linkedlist
	public void insertAtFront(double cashBal, double intRate, double spyInvest, int shareBal, double currSPYprice)
	{
		head = new Node(cashBal, intRate, spyInvest, shareBal, currSPYprice, head);
	}

	//method overloading to do the same thing as the method above, except it takes in different parameters
	public void insertAtFront(String date, double currSPYprice)
	{
		head = new Node(date, currSPYprice, head);
	}

	//prints out all of the values within the first node
	public void displayNode()
	{
		Node place = head;
		while (place.next() != null)
		{

			place = place.next();
		}
		System.out.println();
		System.out.printf(
				"Cash Balance: $%.2f \nInterest Rate: %f \nSPY Investments: $%.2f \nShare Balance: %d \nCurrent SPY Price: $%.2f",
				place.getCashBalance(), place.getInterestRate(), place.getSpyInvestment(), place.getShareBalance(),
				place.getCurrentSPYprice());
	}

	//prints out the date and price information within the first node
	public void displayDatePrice()
	{
		Node place = head;
		System.out.print("Date: " + place.getDate() + "\t" + "Current SPY Price/Share: $" + place.getCurrentSPYprice());
		place = place.next();
		System.out.println();
	}

	//returns the number of nodes within the linkedlist
	public int length()
	{
		Node place = head;
		int i = 0;

		while (place != null)
		{
			i++;
			place = place.next();
		}
		return i;
	}

	//returns true if the list is empty, false otherwise
	public boolean isEmpty()
	{
		return head == null;
	}

	//removes the first node of the linkedlist
	public void removeFront()
	{
		Node front = head;
		head = head.next();
	}
}

//class that uses parallel arrays for the user account
//the temp variables are used as placeholders to store a running total that the arrays will grab info from
class ArrayListUserAccount
{
	ArrayList<Double> cashBalance = new ArrayList<>();
	ArrayList<Double> spyInvestment = new ArrayList<>();
	ArrayList<Integer> shareBalance = new ArrayList<>();
	ArrayList<Double> currentSPYprice = new ArrayList<>();

	private double tempCashBal = 1000;
	private double interestRate = .0027;
	private double tempSpyInvestment;
	private int tempShareBal;
	private int monthCounter;

	ArrayList<String> date = new ArrayList<>();
	ArrayList<Double> SPYprice = new ArrayList<>();

	private double cashEntered;
	private double stocksEntered;
	static BufferedReader input;
	static String currentLine;
	private String[] fields;
	private boolean terminate;
	Scanner scan = new Scanner(System.in);

	//reads the SPY file and gives the user input options
	//fills the appropriate arraylists using the SPY data 
	public void initArrayList() throws IOException, ParseException
	{
		input = new BufferedReader(new FileReader("SPY.csv"));
		populateListsFromSPY();
		populateParallelArrayLists();

		terminate = false;
		while (terminate == false)
		{
			System.out.printf("Cash Balance: $%.2f", cashBalance.get(monthCounter));
			System.out.print("\tDate: " + date.get(monthCounter));
			System.out.printf("\tCurrent SPY Price/Share: $%.2f", SPYprice.get(monthCounter));
			System.out.println("\n1. Buy \n2. Sell \n3. Pass \n4. Finish");
			System.out.print("User Input: ");
			int actionSelected = scan.nextInt();

			if (actionSelected == 1)
			{
				System.out.print("Enter $$$ worth of shares you'd like to purchase: ");
				cashEntered = scan.nextDouble();
				if (cashEntered <= cashBalance.get(monthCounter) && cashEntered >= 0)
				{
					buy();
					incrementDate();
				} else
					System.out.println("You do not have the available funds for this transaction.");
			}

			else if (actionSelected == 2)
			{
				System.out.print("Enter the number of shares you'd like to sell: ");
				stocksEntered = scan.nextInt();
				if (stocksEntered <= shareBalance.get(monthCounter) && stocksEntered >= 0)
				{
					sell();
					incrementDate();
				} else
					System.out.println("You do not have the available stocks for this transaction.");
			}

			else if (actionSelected == 3)
			{
				incrementDate();
			}

			else if (actionSelected == 4)
			{
				endProgram();
			} else
			{
				System.out.println("Invalid input detected.");
			}
			System.out.println();

		}
	}

	//calculates values by storing them into temporary variables when the user decides to buy
	//and prints out interim report
	private void buy()
	{
		int sharesBought = (int) (cashEntered / currentSPYprice.get(monthCounter));
		tempShareBal += sharesBought;
		System.out.println("Number of shares purchased: " + sharesBought);
		double actualMoneySpent = tempShareBal * currentSPYprice.get(monthCounter);
		tempCashBal -= sharesBought * currentSPYprice.get(monthCounter);
		tempSpyInvestment += actualMoneySpent;

		System.out.printf("Cash Balance: $%.2f \tValue of SPY Investments: $%.2f \tNumber of Shares Owned: %d \tPrevailing Price: $%.2f\n",
				tempCashBal, tempSpyInvestment, tempShareBal, currentSPYprice.get(monthCounter));
	}

	//calculates values by storing them into temporary variables when the user decides to sell
	//and prints out interim report
	private void sell()
	{
		tempShareBal -= stocksEntered;
		System.out.println("Number of shares sold: " + (int) stocksEntered);
		double moneyEarned = stocksEntered * currentSPYprice.get(monthCounter);
		tempCashBal += stocksEntered * currentSPYprice.get(monthCounter);
		tempSpyInvestment -= moneyEarned;

		System.out.printf("Cash Balance: $%.2f \tValue of SPY Investments: $%.2f \tNumber of Shares Owned: %d \tPrevailing Price: $%.2f\n",
				tempCashBal, tempSpyInvestment, tempShareBal, currentSPYprice.get(monthCounter));
	}

	//ends program and prints out the necessary information including:
	// the last entry recorded, percent change and annualized rate of change
	private void endProgram()
	{
		terminate = true;
		System.out.println("\nSystem Terminated.");
		System.out.printf(
				"Cash Balance: $%.2f \nInterest Rate: %f \nSPY Investments: $%.2f \nShare Balance: %d \nCurrent SPY Price: $%.2f",
				cashBalance.get(monthCounter), interestRate, spyInvestment.get(monthCounter),
				shareBalance.get(monthCounter), currentSPYprice.get(monthCounter));
		double percentChange = (cashBalance.get(monthCounter) - 1000) / 1000;
		double annualizedROC = (percentChange / 12) * monthCounter;
		System.out.printf("\nTotal Account Value: $%.2f \nPercent Change: %.2f \nAnnualized Rate of Change: %.2f",
				(cashBalance.get(monthCounter) + spyInvestment.get(monthCounter)), percentChange, annualizedROC);
		System.exit(0);
	}

	//adds to the the temp values into the respective array after each input
	//removes first 20 indexes of arrays grabbed from the SPY file to simulate 20 days passing
	//as well as incrementing a month counter to keep track of the index in a particular array
	private void incrementDate()
	{
		tempCashBal += cashBalance.get(monthCounter) * interestRate;
		cashBalance.add(tempCashBal);
		spyInvestment.add(tempSpyInvestment);
		shareBalance.add(tempShareBal);
		currentSPYprice.add(SPYprice.get(0));
		for (int i = 0; i <= 20; i++)
		{
			date.remove(0);
			SPYprice.remove(0);
		}
		monthCounter++;
	}

	//adds the default values to the user account arrays 
	//for when the user initiates the array list program
	private void populateParallelArrayLists()
	{
		cashBalance.add(1000.00);
		spyInvestment.add(0.00);
		shareBalance.add(0);
		currentSPYprice.add(SPYprice.get(0));
	}

	//grabs information from the spy file and puts them into two arrays so that they can be read later
	//reverses the lists so that the last dates and prices can appear first when read
	private void populateListsFromSPY() throws NumberFormatException, IOException
	{
		while ((currentLine = input.readLine()) != null)
		{
			fields = currentLine.split(",");
			date.add(fields[0]);
			SPYprice.add(Double.parseDouble(fields[6]));
		}
		Collections.reverse(date);
		Collections.reverse(SPYprice);
		System.out.println();
	}
}

//linked list user account that creates two linkedlists
//one linkedlist will include the user's information in each node and the other will contain information from the SPY file
//the temp variables are used as placeholders to store a running total that the arrays will grab info from
class LinkedListUserAccount
{
	private double tempCashBal = 1000;
	private double interestRate = .0027;
	private double tempSpyInvestment = 0;
	private int tempShareBal = 0;
	private double tempCurrentSPYprice;

	static BufferedReader input;
	static String currentLine;
	private String[] fields;

	private ListBuilder SPYlist;
	private ListBuilder entry;
	private double cashEntered;
	private int stocksEntered;
	private String date;
	private boolean terminate;
	private int monthCounter;

	Scanner scan = new Scanner(System.in);

	//reads the SPY file and gives the user input options
	//fills the appropriate linkedLists using the SPY data 
	public void initLinkedList() throws IOException, ParseException
	{
		SPYlist = new ListBuilder();
		entry = new ListBuilder();
		input = new BufferedReader(new FileReader("SPY.csv"));
		populateLinkedListFromSPY();
		entry.addToBack(tempCashBal, interestRate, tempSpyInvestment, tempShareBal, tempCurrentSPYprice);

		terminate = false;
		while (terminate == false)
		{
			System.out.printf("Cash Balance: $%.2f \t", tempCashBal);
			SPYlist.displayDatePrice();
			System.out.println("1. Buy \n2. Sell \n3. Pass \n4. Finish");
			System.out.print("User Input: ");
			int actionSelected = scan.nextInt();

			if (actionSelected == 1)
			{
				System.out.print("Enter $$$ worth of shares you'd like to purchase: ");
				cashEntered = scan.nextDouble();
				if (cashEntered <= tempCashBal && cashEntered >= 0)
				{
					buy();
					incrementDate();
				} else
					System.out.println("You do not have the available funds for this transaction.");
			} else if (actionSelected == 2)
			{
				System.out.print("Enter the number of shares you'd like to sell: ");
				stocksEntered = scan.nextInt();
				if (stocksEntered <= tempShareBal && stocksEntered >= 0)
				{
					sell();
					incrementDate();
				} else
					System.out.println("You do not have the available stocks for this transaction.");
			}

			else if (actionSelected == 3)
			{
				incrementDate();
			}

			else if (actionSelected == 4)
			{
				endProgram();
			} else
			{
				System.out.println("Invalid input detected.");
			}
			System.out.println();
		}
	}

	// removes 20 nodes from the linkedlist SPYlist
	// calculates new cash balance with interest rate
	// takes a snapshot of the account's temp variables and adds that to the linkedlist entry
	public void incrementDate()
	{
		for (int i = 0; i <= 20; i++)
		{
			SPYlist.removeFront();
		}
		tempCashBal += (float) (tempCashBal * interestRate);
		entry.addToBack(tempCashBal, interestRate, tempSpyInvestment, tempShareBal, SPYlist.getPriceNode());
		monthCounter++;
	}

	// populates linkedlist SPYlist with the dates and price from SPY.csv
	public void populateLinkedListFromSPY() throws IOException, ParseException
	{
		while ((currentLine = input.readLine()) != null)
		{
			fields = currentLine.split(",");
			date = fields[0];
			tempCurrentSPYprice = Double.parseDouble(fields[6]);
			SPYlist.insertAtFront(date, tempCurrentSPYprice);
		}
		System.out.println();
	}

	// updates the UserAccount's placeholder variables after each transaction
	public void buy()
	{
		int sharesBought = (int) (cashEntered / tempCurrentSPYprice);
		tempShareBal += sharesBought;
		System.out.println("Number of shares purchased: " + sharesBought);
		double actualMoneySpent = tempShareBal * tempCurrentSPYprice;
		tempCashBal -= sharesBought * tempCurrentSPYprice;
		tempSpyInvestment += actualMoneySpent;

		System.out.printf("Cash Balance: $%.2f \tValue of SPY Investments: $%.2f \tNumber of Shares Owned: %d \tPrevailing Price: $%.2f\n",
				tempCashBal, tempSpyInvestment, tempShareBal, tempCurrentSPYprice);
	}

	// updates the UserAccount's placeholder variables after each transaction
	public void sell()
	{
		tempShareBal -= stocksEntered;
		System.out.println("Number of shares sold: " + stocksEntered);
		double moneyEarned = stocksEntered * tempCurrentSPYprice;
		tempCashBal += stocksEntered * tempCurrentSPYprice;
		tempSpyInvestment -= moneyEarned;

		System.out.printf("Cash Balance: $%.2f \tValue of SPY Investments: $%.2f \tNumber of Shares Owned: %d \tPrevailing Price: $%.2f\n",
				tempCashBal, tempSpyInvestment, tempShareBal, tempCurrentSPYprice);
	}

	// prints out information from the last node created, percent change and
	// annualized rate of change
	// terminates program
	public void endProgram()
	{
		terminate = true;
		System.out.println("System Terminated.");
		entry.displayNode();
		double percentChange = (tempCashBal - 1000) / 1000;
		double annualizedROC = (percentChange / 12) * monthCounter;
		System.out.printf("\nTotal Account Value: $%.2f \nPercent Change: %.2f \nAnnualized Rate of Change: %.2f",
				(tempCashBal + tempSpyInvestment), percentChange, annualizedROC);
		System.exit(0);
	}
}
