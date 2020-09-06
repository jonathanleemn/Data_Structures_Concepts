package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Author: Jonathan Lee
 */
public class FileIO
{
	static BufferedReader input;
	static String currentLine;
	private String[] fields;
	public SortedList<Double> jan, feb, mar, apr, may, jun, jul, aug, sept, oct, nov, dec;
	public double janHigh, febHigh, marHigh, aprHigh, mayHigh, junHigh, julHigh, augHigh, septHigh, octHigh, novHigh,
			decHigh;

	// arbitrary assigned 150 to each month as the default lowest temp
	public double janLow = 150, febLow = 150, marLow = 150, aprLow = 150, mayLow = 150, junLow = 150, julLow = 150,
			augLow = 150, septLow = 150, octLow = 150, novLow = 150, decLow = 150;

	// arbitrarily assigned -100 to tempM and tempN as placeholders
	public double tempM = -100, tempN = -100, missingTemp;
	public int missingCounter;

	// reads the csv file and puts the temperatures into a list according to its
	// month
	FileIO() throws IOException
	{
		input = new BufferedReader(new FileReader("MNMINPLS.csv"));
		jan = new SortedList<Double>();
		feb = new SortedList<Double>();
		mar = new SortedList<Double>();
		apr = new SortedList<Double>();
		may = new SortedList<Double>();
		jun = new SortedList<Double>();
		jul = new SortedList<Double>();
		aug = new SortedList<Double>();
		sept = new SortedList<Double>();
		oct = new SortedList<Double>();
		nov = new SortedList<Double>();
		dec = new SortedList<Double>();

		while ((currentLine = input.readLine()) != null)
		{
			fields = currentLine.split(",");
			int month = Integer.parseInt(fields[0]);
			double temp = Double.parseDouble(fields[3]);
			addTempToList(month, temp);
			fillMissingData(month, temp);
		}
	}

	// accounts for the missing data by interpolating the data that came
	// before/after it
	public void fillMissingData(int month, double temp)
	{
		if (temp != -99 && missingCounter == 0)
		{
			tempN = temp;
		}

		if (missingCounter > 0 && temp != -99)
		{
			tempM = temp;
			missingTemp = ((tempM - tempN) / 2) + tempN;
			addTempToList(month, missingTemp);
			missingCounter = 0;
		}

		if (temp == -99)
		{
			missingCounter++;
		}
	}

	// method to add temperatures to a SortedList according to its month
	public void addTempToList(int month, double temp)
	{
		switch (month)
		{
		case 1:
			if (temp != -99)
			{
				jan.add(temp);
				if (temp > janHigh)
					janHigh = temp;
				if (temp < janLow)
					janLow = temp;
			}
			break;
		case 2:
			if (temp != -99)
			{
				feb.add(temp);
				if (temp > febHigh)
					febHigh = temp;
				if (temp < febLow)
					febLow = temp;
			}
			break;
		case 3:
			if (temp != -99)
			{
				mar.add(temp);
				if (temp > marHigh)
					marHigh = temp;
				if (temp < marLow)
					marLow = temp;
			}
			break;
		case 4:
			if (temp != -99)
			{
				apr.add(temp);
				if (temp > aprHigh)
					aprHigh = temp;
				if (temp < aprLow)
					aprLow = temp;
			}
			break;
		case 5:
			if (temp != -99)
			{
				may.add(temp);
				if (temp > mayHigh)
					mayHigh = temp;
				if (temp < mayLow)
					mayLow = temp;
			}
			break;
		case 6:
			if (temp != -99)
			{
				jun.add(temp);
				if (temp > junHigh)
					junHigh = temp;
				if (temp < junLow)
					junLow = temp;
			}
			break;
		case 7:
			if (temp != -99)
			{
				jul.add(temp);
				if (temp > julHigh)
					julHigh = temp;
				if (temp < julLow)
					julLow = temp;
			}
			break;
		case 8:
			if (temp != -99)
			{
				aug.add(temp);
				if (temp > augHigh)
					augHigh = temp;
				if (temp < augLow)
					augLow = temp;
			}
			break;
		case 9:
			if (temp != -99)
			{
				sept.add(temp);
				if (temp > septHigh)
					septHigh = temp;
				if (temp < septLow)
					septLow = temp;
			}
			break;
		case 10:
			if (temp != -99)
			{
				oct.add(temp);
				if (temp > octHigh)
					octHigh = temp;
				if (temp < octLow)
					octLow = temp;
			}
			break;
		case 11:
			if (temp != -99)
			{
				nov.add(temp);
				if (temp > novHigh)
					novHigh = temp;
				if (temp < novLow)
					novLow = temp;
			}
			break;
		case 12:
			if (temp != -99)
			{
				dec.add(temp);
				if (temp > decHigh)
					decHigh = temp;
				if (temp < decLow)
					decLow = temp;
			}
			break;
		}
	}

}
