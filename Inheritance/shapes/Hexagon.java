package shapes;

public class Hexagon extends Shape
{	
	double sideLength;
	
	public Hexagon(double sideLength, String name)
	{
		super(name);
		this.sideLength = sideLength;
	}

	@Override
	public void calcArea()
	{
		super.setArea(((3*Math.sqrt(3))/2)*Math.pow(sideLength, 2));
	}

	@Override
	public void calcPerimeter()
	{
		super.setPerimeter(sideLength*6);
	}

	public double getSideLength()
	{
		return sideLength;
	}

	public void setSideLength(double sideLength)
	{
		this.sideLength = sideLength;
	}

	@Override
	public String toString()
	{
		return "Hexagon [sideLength=" + sideLength + "]";
	}

}
