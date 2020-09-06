package lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO
{
	BufferedReader input;
	String currentLine;
	String[] fields;
	ArrayList<String> questions;
	ArrayList<String> OOP, generics, complexity, lists, recursion, bags, sortedList, binarySearch, sorting,
			stacksAndQueues, hashing, trees, heaps, graphs;

	FileIO() throws IOException
	{
		input = new BufferedReader(new FileReader("structures 2 final questions.txt"));
		questions = new ArrayList<String>();
		OOP = new ArrayList<String>();
		generics = new ArrayList<String>();
		complexity = new ArrayList<String>();
		lists = new ArrayList<String>();
		recursion = new ArrayList<String>();
		bags = new ArrayList<String>();
		sortedList = new ArrayList<String>();
		binarySearch = new ArrayList<String>();
		sorting = new ArrayList<String>();
		stacksAndQueues = new ArrayList<String>();
		hashing = new ArrayList<String>();
		trees = new ArrayList<String>();
		heaps = new ArrayList<String>();
		graphs = new ArrayList<String>();

		while ((currentLine = input.readLine()) != null)
		{
			fields = currentLine.split("::");
			String questionType = fields[3].replace(" ", "").toLowerCase();
			addQuestionToList(questionType);

			questions.add(fields[1]);
		}
		input.close();
	}

	public void addQuestionToList(String questionType)
	{
		switch (questionType)
		{
		case "ooprogramming":
			OOP.add(fields[1]);
			break;
		case "generics":
			generics.add(fields[1]);
			break;
		case "complexity&efficiency":
			complexity.add(fields[1]);
			break;
		case "lists":
			lists.add(fields[1]);
			break;
		case "recursion":
			recursion.add(fields[1]);
			break;
		case "bags&sets":
			bags.add(fields[1]);
			break;
		case "sortedlist":
			sortedList.add(fields[1]);
			break;
		case "binarysearch/iterators":
			binarySearch.add(fields[1]);
			break;
		case "sorting":
			sorting.add(fields[1]);
			break;
		case "stacks&queues":
			stacksAndQueues.add(fields[1]);
			break;
		case "assocarrays/hashing":
			hashing.add(fields[1]);
			break;
		case "trees":
			trees.add(fields[1]);
			break;
		case "heaps/balancedsearchtrees":
			heaps.add(fields[1]);
			break;
		case "graphs":
			graphs.add(fields[1]);
			break;
		}
	}
}
