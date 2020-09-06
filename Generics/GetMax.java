
public class GetMax
{
	public static void main(String args[])
	{
		Integer[] i =
		{ 1, 2, 3, 4, 5 };
		Character[] c =
		{ 'a', 'b', 'c', 'd', 'e' };
		TestMaxInterface<Integer> instance_i = new TestMax<>(i);
		TestMaxInterface<Character> instance_c = new TestMax<>(c);
		System.out.println("Max of ints: " + instance_i.max());
		System.out.println("Max of chars: " + instance_c.max());
	}
}
