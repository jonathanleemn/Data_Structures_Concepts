package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileIO<T> 
{
	static BufferedReader input;
	static BufferedWriter output;
	static String currentLine;
	private String[] fields;
	protected ArrayList<String> date;
	protected ArrayList<Long> volume;
	protected ArrayList<String> adjClose;
	protected ArrayList<Integer> volume2;

	//reads in SPY file and copies columns 1, 6, and 7 into an arraylist
	FileIO() throws IOException
	{
		input = new BufferedReader(new FileReader("SPY.csv"));
		date = new ArrayList<String>();
		volume = new ArrayList<Long>();
		adjClose = new ArrayList<String>();
		volume2 = new ArrayList<Integer>();

		while ((currentLine = input.readLine()) != null)
		{
			fields = currentLine.split(",");
			date.add(fields[0]);
			volume.add(Long.parseLong(fields[5]));
			adjClose.add(fields[6]);
			volume2.add(Integer.parseInt(fields[5]));
		}	
		input.close();
	}

	/*
	 * Method that writes the data in a newly created file
	 * ArrayIndexComparator sorts an array while keeping the indexes intact
	 * I then applied these indexes in a for loop to indicate which indexes to select 
	 * when writing the data to the csv file.
	 */
	public void writeToFile(Long[] list) throws IOException
	{	
		output = new BufferedWriter(new FileWriter("SPY_sorted.csv"));
		ArrayIndexComparator comparator = new ArrayIndexComparator(list);
		Integer[] newIndex = comparator.createIndexArray();
		Arrays.sort(newIndex, comparator);
		
		for(int i = 0; i<newIndex.length; i++)
        {
            output.write(date.get(newIndex[i]));
            output.append(",");
            output.write(Long.toString(volume.get(newIndex[i])));
            output.append(",");
            output.write(adjClose.get(newIndex[i]));
            output.newLine();
        }
		output.close();
	}
}
