import java.util.List;
import java.util.Arrays;

public class UBGeneric
{
	public static double average(List<? extends Number> ln)
	{
		double sum = 0.0;
		int count = 0;
		for (Number n : ln)
		{
			sum += n.doubleValue();
			count++;
		}
		return sum / count;
	}

	public static void main(String[] args)
	{
		List<Integer> li = Arrays.asList(2, 4, 8); // result is 7 from list of
													// ints
		System.out.println("average is: " + average(li));
		List<Double> ld = Arrays.asList(2.4, 4.4, 8.4); // result is 7.6
		System.out.println("average is: " + average(ld));
	}
}
