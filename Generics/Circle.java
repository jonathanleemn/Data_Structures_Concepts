
public class Circle implements Comparable<Circle>
{
	private int radius;
	
	public int getRadius()
	{
		return radius;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public int compareTo(Circle other)
	{
		int result;
		if(this.equals(other)) result = 0; //equals a boolean
		else if(radius <other.radius) result = -1;
		else result = 1;
		return result;
	}
	
}
