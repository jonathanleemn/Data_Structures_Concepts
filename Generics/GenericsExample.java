
public class GenericsExample
{

	public static void main(String[] args)
	{
		String[] myStringArray = {"abc", "def", "ghi", "jkl"};
		printArray(myStringArray);
		
		Character[] myCharArray = {'A', 'B', 'C', 'D'};
		printArray(myCharArray);
	}
	
	public static<T> void printArray(T[] someArray)
	{
		for(T element : someArray)
		{
			System.out.println(element);
		}
	}
}
