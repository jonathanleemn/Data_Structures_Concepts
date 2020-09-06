import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Driver
{
	public static void main(String[] args)
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("134.29.150.220", "nhcc.edu");

		HashMap<String, String> tm = new HashMap<String, String>();
		tm.put("204.77.42.101", "normandale.edu");
		
		HashMap<String, String> a = new HashMap<String, String>();
		a.putAll(hm);
		a.putAll(tm);
	}
}
