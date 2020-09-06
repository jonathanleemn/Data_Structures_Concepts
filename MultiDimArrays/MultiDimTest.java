package lectureFiles;

public class MultiDimTest
{

	public static void main(String[] args)
	{
		MultiDimPractice practice = new MultiDimPractice();
		
		practice.fillArray();
		practice.printArray();
		
		//fills the third column with 0s and then prints it
		System.out.println();
		practice.fillColumn(3);
		System.out.println();
		practice.printArray();
		
		System.out.println();
		practice.printRagged();
		
		System.out.println();
		practice.traverseRange(1, 2);
	}

}
