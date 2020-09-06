
// FakeMda.java
import java.util.*;
import java.text.DecimalFormat;

class FakeMda
{
	public static void main(String args[])
	{
		// Create hash map
		Map<String, Double> aa = new HashMap<String, Double>();
		int limit = 4;
		double value = 100.00;
		double rate = 0.0625;
		DecimalFormat df = new DecimalFormat("#.00");

		// Put elements in map
		for (int i = 0; i < limit; i++)
		{
			for (int j = 0; j < limit; j++)
			{
				String key = "" + i + "," + j;
				value *= (1 + rate);
				aa.put(key, new Double(df.format(value)));
			}
		}

		// display elements
		for (int i = 0; i < limit; i++)
		{
			for (int j = 0; j < limit; j++)
			{
				String key = "" + i + "," + j;
				System.out.print("\t(" + key + "): " + aa.get(key));
			}
			System.out.println();
		}
	}
}