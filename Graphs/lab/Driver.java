package lab;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Driver
{
	static SecureRandom rng = new SecureRandom();
	static ArrayList<String> OOP = new ArrayList<String>();
	static ArrayList<String> generics = new ArrayList<String>();
	static ArrayList<String> complexity = new ArrayList<String>();
	static ArrayList<String> lists = new ArrayList<String>();
	static ArrayList<String> recursion = new ArrayList<String>();
	static ArrayList<String> bags = new ArrayList<String>();
	static ArrayList<String> sortedList = new ArrayList<String>();
	static ArrayList<String> binarySearch = new ArrayList<String>();
	static ArrayList<String> sorting = new ArrayList<String>();
	static ArrayList<String> stacksAndQueues = new ArrayList<String>();
	static ArrayList<String> hashing = new ArrayList<String>();
	static ArrayList<String> trees = new ArrayList<String>();
	static ArrayList<String> heaps = new ArrayList<String>();
	static ArrayList<String> graphs = new ArrayList<String>();

	public static void main(String[] args) throws IOException
	{
		FileIO fio = new FileIO();
		populateLists(fio);

		DirectedGraph<ArrayList<String>> graph = new DirectedGraph<ArrayList<String>>();
		graph.addVertex(OOP);
		graph.addVertex(generics);
		graph.addVertex(complexity);
		graph.addVertex(lists);
		graph.addVertex(recursion);
		graph.addVertex(bags);
		graph.addVertex(sortedList);
		graph.addVertex(binarySearch);
		graph.addVertex(sorting);
		graph.addVertex(stacksAndQueues);
		graph.addVertex(hashing);
		graph.addVertex(trees);
		graph.addVertex(heaps);
		graph.addVertex(graphs);
		
		graph.addEdge(OOP, generics, 1);
		graph.addEdge(generics, complexity, 2);
		graph.addEdge(complexity, lists, 3);
		graph.addEdge(lists, recursion, 4);
		graph.addEdge(recursion, bags, 5);
		graph.addEdge(bags, sortedList, 6);
		graph.addEdge(sortedList, binarySearch, 7);
		graph.addEdge(binarySearch, sorting, 8);
		graph.addEdge(sorting, stacksAndQueues, 9);
		graph.addEdge(stacksAndQueues, hashing, 10);
		graph.addEdge(hashing, trees, 11);
		graph.addEdge(trees, heaps, 12);
		graph.addEdge(heaps, graphs, 13);

	}

	static void add3QuestionsToNewList(FileIO fio, ArrayList<String> fioList, ArrayList<String> newList)
	{
		ArrayList<Integer> numList = new ArrayList<Integer>();
		int questionCounter = 3;

		for (int i = 0; i < questionCounter; i++)
		{
			int questionSelector = rng.nextInt(fioList.size());
			while (numList.contains(questionSelector))
			{
				questionSelector = rng.nextInt(fioList.size());
			}
			numList.add(questionSelector);
			newList.add(fioList.get(numList.get(i)));
			System.out.println(fioList.get(numList.get(i)));
		}
	}

	private static void populateLists(FileIO fio)
	{
		add3QuestionsToNewList(fio, fio.OOP, OOP);
		add3QuestionsToNewList(fio, fio.generics, generics);
		add3QuestionsToNewList(fio, fio.complexity, complexity);
		add3QuestionsToNewList(fio, fio.lists, lists);
		add3QuestionsToNewList(fio, fio.recursion, recursion);
		add3QuestionsToNewList(fio, fio.bags, bags);
		add3QuestionsToNewList(fio, fio.sortedList, sortedList);
		add3QuestionsToNewList(fio, fio.binarySearch, binarySearch);
		add3QuestionsToNewList(fio, fio.sorting, sorting);
		add3QuestionsToNewList(fio, fio.stacksAndQueues, stacksAndQueues);
		add3QuestionsToNewList(fio, fio.hashing, hashing);
		add3QuestionsToNewList(fio, fio.trees, trees);
		add3QuestionsToNewList(fio, fio.heaps, heaps);
		add3QuestionsToNewList(fio, fio.graphs, graphs);

	}

}
