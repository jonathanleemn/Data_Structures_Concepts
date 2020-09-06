package basicdrawing;

import java.awt.Dimension;

public class Shape
{
	private int height, width;
	private Location loc;

	public Shape(Location loc, int h, int w)
	{
		height = h;
		width = w;
		this.loc = loc;
	}

	public Location getLoc()
	{
		return loc;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public void move(int x, int y, Dimension panelSize)
	{
		if (isValidMove(x, y, (int) panelSize.getWidth(), (int) panelSize.getHeight()))
		{
			getLoc().setX(getLoc().getX() + x);
			getLoc().setY(getLoc().getY() + y);
		}
	}

	public boolean isValidMove(int x, int y, int w, int h)
	{
		return isValidXMove(x, w) && isValidYMove(y, h);
	}

	public boolean isValidXMove(int x, int w)
	{
		return ((loc.getX() + x) <= w - 10) && getLoc().getX() + x >= 0;
	}

	public boolean isValidYMove(int y, int h)
	{
		return (loc.getY() + y) <= h - 10 && getLoc().getY() + y >= 0;
	}

}
