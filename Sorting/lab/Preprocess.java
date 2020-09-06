package lab;
import java.util.List;

/*
 * pre-processes data into a comparable array
 */
class Preprocess<T extends Comparable<? super T>>
{

	@SuppressWarnings("unchecked")
	public T[] convertList(List<T> toConvert)
	{

		if (toConvert.contains(null))
		{
			toConvert.remove(null);
		}
		T[] converted = (T[]) new Integer[toConvert.size()];

		for (int i = 0; i < toConvert.size(); i++)
		{

			if (!(toConvert.get(i) == null))
			{
				converted[i] = toConvert.get(i);
			}
		}
		return converted;
	}
}
