
public class TestMax<T extends Comparable<T>> implements TestMaxInterface<T>
{

	T[] values;

	TestMax(T[] t)
	{
		values = t;
	}

	public T max()
	{
		T v = values[0];
		for (int i = 1; i < values.length; i++)
			// compareTo returns 0 if equivalent, 1 if left operand >, -1 if
			// right operand >
			if (values[i].compareTo(v) > 0)
				v = values[i];
		return v;
	}
}
