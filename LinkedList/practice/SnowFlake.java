package practice;

//SnowFlake.java
import java.awt.*;
import javax.swing.*;

public class SnowFlake extends JApplet
{
	public void makeSnowflake(Graphics g, int x, int y, int scale, int level)
	{
		for (int angle = 0; angle < 360; angle += 40)
		{
			double rad = angle * Math.PI / 180;
			int x2 = (int) (x + Math.cos(rad) * scale);
			int y2 = (int) (y + Math.sin(rad) * scale);
			g.drawLine(x, y, x2, y2);
			if (scale > 0)
			{
				makeSnowflake(g, x2, y2, scale / 3, level - 1);
			}
		}
	}

	public void paint(Graphics g)
	{
		makeSnowflake(g, 200, 200, 120, 5);
	}
}