
public class Driver
{

	public static void main(String[] args)
	{
		int[] num = new int[3];
		num[0] = 37;
		num[1] = 36;
		num[2] = 29;
		System.out.println(isHeap(num));
		
		MaxHeap<Integer> max = new MaxHeap<Integer>();
		max.add(22);
		max.add(1);
		max.add(33);
		max.add(5);
		System.out.println(max.getSize());
		
	}

	public static boolean isHeap(int[] a)
	{
		int n = a.length;
		for (int i = n / 2; i < n; i++)
		{
			for (int j = i; j > 1; j /= 2)
			{
				if (a[j / 2] < a[j])
				{
					return false;
				}
			}
		}
		return true;
	}

}
