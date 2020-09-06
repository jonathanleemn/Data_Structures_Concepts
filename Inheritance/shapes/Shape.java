package shapes;

public abstract class Shape
{
	private double area, perimeter;
	private String name;

	public Shape(String n)
	{
		this.name = n;
	}

	public abstract void calcArea();

	public abstract void calcPerimeter();

	public double getArea()
	{
		return area;
	}

	public void setArea(double area)
	{
		this.area = area;
	}

	public double getPerimeter()
	{
		return perimeter;
	}

	public void setPerimeter(double perimeter)
	{
		this.perimeter = perimeter;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Shape [area=" + area + ", perimeter=" + perimeter + ", name=" + name + "]";
	}

}
