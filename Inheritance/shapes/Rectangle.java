package shapes;

public class Rectangle extends Shape
{
	private double height, width;

	// constructor
	public Rectangle(double height, double width, String name)
	{
		super(name);
		this.height = height;
		this.width = width;
	}

	// overrides abstract method in the parent class
	@Override
	public void calcArea()
	{
		// super specifies which area is going to be chosen
		super.setArea(height * width);
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	@Override
	public void calcPerimeter()
	{
		super.setPerimeter((height + width) * 2);
	}

	@Override
	public String toString()
	{
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}
}
