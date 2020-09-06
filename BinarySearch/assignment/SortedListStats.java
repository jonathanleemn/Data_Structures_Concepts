package assignment;

/*
 * Author: Jonathan Lee
 * Date: 2/27/2017
 */
import java.io.IOException;

public class SortedListStats extends FileIO
{
	double janAvgTemp, febAvgTemp, marAvgTemp, aprAvgTemp, mayAvgTemp, junAvgTemp, julAvgTemp, augAvgTemp, septAvgTemp,
			octAvgTemp, novAvgTemp, decAvgTemp;
	double janMedTemp, febMedTemp, marMedTemp, aprMedTemp, mayMedTemp, junMedTemp, julMedTemp, augMedTemp, septMedTemp,
	octMedTemp, novMedTemp, decMedTemp;	
	Integer MPRjan, MPRfeb, MPRmar, MPRapr, MPRmay, MPRjun, MPRjul, MPRaug, MPRsept, MPRoct, MPRnov, MPRdec;


	SortedListStats() throws IOException
	{
		super();
		averageTemperature();
		medianTemperature();
		calculateMPR();
	}
	
	public void calculateMPR()
	{
		MPRjan = (int) (100 * (janMedTemp - janLow) / (janHigh - janLow));
		MPRfeb = (int) (100 * (febMedTemp - febLow) / (febHigh - febLow));
		MPRmar = (int) (100 * (marMedTemp - marLow) / (marHigh - marLow));
		MPRapr = (int) (100 * (aprMedTemp - aprLow) / (aprHigh - aprLow));
		MPRmay = (int) (100 * (mayMedTemp - mayLow) / (mayHigh - mayLow));
		MPRjun = (int) (100 * (junMedTemp - junLow) / (junHigh - junLow));
		MPRjul = (int) (100 * (julMedTemp - julLow) / (julHigh - julLow));
		MPRaug = (int) (100 * (augMedTemp - augLow) / (augHigh - augLow));
		MPRsept = (int) (100 * (septMedTemp - septLow) / (septHigh - septLow));
		MPRoct = (int) (100 * (octMedTemp - octLow) / (octHigh - octLow));
		MPRnov = (int) (100 * (novMedTemp - novLow) / (novHigh - novLow));
		MPRdec = (int) (100 * (decMedTemp - decLow) / (decHigh - decLow));
	}

	//calculates the average temperature for each month
	//takes the highest + lowest and then divides that by 2
	public void averageTemperature()
	{
		janAvgTemp = (janHigh + janLow) / 2;
		febAvgTemp = (febHigh + febLow) / 2;
		marAvgTemp = (marHigh + marLow) / 2;
		aprAvgTemp = (aprHigh + aprLow) / 2;
		mayAvgTemp = (mayHigh + mayLow) / 2;
		junAvgTemp = (junHigh + junLow) / 2;
		julAvgTemp = (julHigh + julLow) / 2;
		augAvgTemp = (augHigh + augLow) / 2;
		septAvgTemp = (septHigh + septLow) / 2;
		octAvgTemp = (octHigh + octLow) / 2;
		novAvgTemp = (novHigh + novLow) / 2;
		decAvgTemp = (decHigh + decLow) / 2;
	}

	//finds median temperature of each month
	//finds the entry in the middle of the list
	public void medianTemperature()
	{
		janMedTemp = jan.getEntry(jan.getLength()/2);
		febMedTemp = feb.getEntry(feb.getLength()/2);
		marMedTemp = mar.getEntry(mar.getLength()/2);
		aprMedTemp = apr.getEntry(apr.getLength()/2);
		mayMedTemp = may.getEntry(may.getLength()/2);
		junMedTemp = jun.getEntry(jun.getLength()/2);
		julMedTemp = jul.getEntry(jul.getLength()/2);
		augMedTemp = aug.getEntry(aug.getLength()/2);
		septMedTemp = sept.getEntry(sept.getLength()/2);
		octMedTemp = oct.getEntry(oct.getLength()/2);
		novMedTemp = nov.getEntry(nov.getLength()/2);
		decMedTemp = dec.getEntry(dec.getLength()/2);
	}

	//plots the median temperature for each month in a bar graph
	public void plotMedian()
	{
		double tempCounter = 0;
		System.out.print("\nJan. Median Temperature: ");
		while(tempCounter < janMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nFeb. Median Temperature: ");
		while(tempCounter < febMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nMar. Median Temperature: ");
		while(tempCounter < marMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nApr. Median Temperature: ");
		while(tempCounter < aprMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nMay  Median Temperature: ");
		while(tempCounter < mayMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nJun. Median Temperature: ");
		while(tempCounter < junMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nJul. Median Temperature: ");
		while(tempCounter < julMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nAug. Median Temperature: ");
		while(tempCounter < augMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nSep. Median Temperature: ");
		while(tempCounter < septMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nOct. Median Temperature: ");
		while(tempCounter < octMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nNov. Median Temperature: ");
		while(tempCounter < novMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nDec. Median Temperature: ");
		while(tempCounter < decMedTemp)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		System.out.println("\n\t\t\t Temperature in Fahrenheit (* = 1 degree)");
	}

	//plots the max temperature for each month in a bar graph
	public void plotMax()
	{
		double tempCounter = 0;
		System.out.print("\nJan. Max Temperature: ");
		while(tempCounter < janHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nFeb. Max Temperature: ");
		while(tempCounter < febHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nMar. Max Temperature: ");
		while(tempCounter < marHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nApr. Max Temperature: ");
		while(tempCounter < aprHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nMay  Max Temperature: ");
		while(tempCounter < mayHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nJun. Max Temperature: ");
		while(tempCounter < junHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nJul. Max Temperature: ");
		while(tempCounter < julHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nAug. Max Temperature: ");
		while(tempCounter < augHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nSep. Max Temperature: ");
		while(tempCounter < septHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nOct. Max Temperature: ");
		while(tempCounter < octHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nNov. Max Temperature: ");
		while(tempCounter < novHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nDec. Max Temperature: ");
		while(tempCounter < decHigh)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		System.out.println("\n\t\t\t Temperature in Fahrenheit (* = 1 degree)");
	}

	//plots the min temperature for each month in a bar graph
	public void plotMin()
	{
		double tempCounter = 0;
		System.out.print("\nJan. Min Temperature: ");
		while(tempCounter > janLow)
		{
			System.out.print("-");
			tempCounter -= 1;
		}
		
		tempCounter = 0;
		System.out.print("\nFeb. Min Temperature: ");
		while(tempCounter > febLow)
		{
			System.out.print("-");
			tempCounter -= 1;
		}
		
		tempCounter = 0;
		System.out.print("\nMar. Min Temperature: ");
		while(tempCounter > marLow)
		{
			System.out.print("-");
			tempCounter -= 1;
		}
		
		tempCounter = 0;
		System.out.print("\nApr. Min Temperature: ");
		while(tempCounter < aprLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nMay  Min Temperature: ");
		while(tempCounter < mayLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nJun. Min Temperature: ");
		while(tempCounter < junLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nJul. Min Temperature: ");
		while(tempCounter < julLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nAug. Min Temperature: ");
		while(tempCounter < augLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nSep. Min Temperature: ");
		while(tempCounter < septLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nOct. Min Temperature: ");
		while(tempCounter < octLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nNov. Min Temperature: ");
		while(tempCounter < novLow)
		{
			System.out.print("*");
			tempCounter += 1;
		}
		
		tempCounter = 0;
		System.out.print("\nDec. Min Temperature: ");
		while(tempCounter > decLow)
		{
			System.out.print("-");
			tempCounter -= 1;
		}
		System.out.println("\n\t\t\t Temperature in Fahrenheit (* = 1 degree, - = -1 degree)");
	}
}
