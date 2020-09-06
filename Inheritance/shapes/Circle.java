package shapes;

public class Circle extends Shape
{
	double radius;
	
	public Circle(double r, String name)
	{
		super(name);
		radius = r;
	}
	
	@Override
	public void calcArea()
	{
		super.setArea(Math.PI * radius * radius);
	}

	@Override
	public void calcPerimeter()
	{
		super.setPerimeter(2*Math.PI*radius);
	}
	
	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	@Override
	public String toString()
	{
		return "Circle [radius=" + radius + "]";
	}



}
