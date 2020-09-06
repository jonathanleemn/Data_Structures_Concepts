package shapes;

public class Main
{

	public static void main(String[] args)
	{
		Square s1 = new Square(4.5, "Square");
		s1.calcArea();
		s1.calcPerimeter();
		System.out.println(s1.getPerimeter());
		System.out.println(s1);
	}

}
