import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IPtoDomain
{
	public static void main(String[] args)
	{
		// Create hash map
		HashMap<String, String> hm = new HashMap<String, String>();
		
		// Put elements in map
		hm.put("134.29.150.220", "nhcc.edu");
		hm.put("204.77.42.101", "normandale.edu");
		hm.put("199.17.234.21", "metrostate.edu");
		hm.put("134.84.119.107", "umn.edu");
		
		// Get a set of the entries
		Set set = hm.entrySet();
		
		// Get an iterator
		Iterator i = set.iterator();
		
		// Display elements
		while (i.hasNext())
		{
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
	}
}
