package shapes;

public class Square extends Rectangle
{
	public Square(double side, String n)
	{
		super(side, side, n);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " is square: " + isSquare();
	}
	
	boolean isSquare()
	{
		return getHeight() == getWidth();
	}
}
