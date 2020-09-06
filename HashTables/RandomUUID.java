import java.util.UUID;
public class RandomUUID
{
	public static void main(String[] args)
	{
		UUID id = UUID.randomUUID();
		// myHashMap.put(id.toString(), somevalue);
		System.out.println(id.toString());
	}

}