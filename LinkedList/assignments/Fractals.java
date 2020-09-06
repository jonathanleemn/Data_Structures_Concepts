package assignments;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JFrame;

//Author: Jonathan Lee
//Purpose: To create a fractal using recursive and iterative methods
//Due Date: 2/16/2017
//Source of recursive fractal: http://rosettacode.org/wiki/Mandelbrot_set#Java

/*
 * In the iterative method, I created a TreeObject class (with the help of a friend) 
 * that I put into a new linkedlist of queue that took in TreeObjects. 
 * When the object is popped, it pushes in 2 more objects of TreeObject and keeps looping until
 * it runs out, which is an example of scaling and self-similarity. 
 * The recursive method uses self-similarity and scaling in a more elegant manner since it doesn't
 * have to go through the hurdle of creating a TreeObject class and putting that into a list and instead calls itself repeatedly until
 * the depth is 0.
 */

public class Fractals extends JFrame
{
	int counter;
	
	public static void main(String[] args)
	{
		new Fractals().setVisible(true);
	}
	
	private Fractals()
	{
		super("Fractal Tree");
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void drawRecursive(Graphics g, int x1, int y1, double angle, int depth)
	{
		if (depth == 0)
		{
			return;
		}
		int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
		int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
		counter+=2;
		g.drawLine(x1, y1, x2, y2);
		drawRecursive(g, x2, y2, angle - 40, depth - 1);
		drawRecursive(g, x2, y2, angle + 40, depth - 1);
	}

	private void drawIterative(Graphics g, int x1, int y1, double angle, int maxDepth)
	{
		Queue<TreeObject> openList = new LinkedList<>();
		openList.add(new TreeObject(x1, y1, angle, maxDepth));
		counter++;

		TreeObject tmp;
		while ((tmp = openList.poll()) != null)
		{
			expand(openList, tmp, g, maxDepth);
			counter++;
		}
	}

	private void expand(Queue<TreeObject> objects, TreeObject current, Graphics g, int maxDepth)
	{
		int x2 = current.x1 + (int) (Math.cos(Math.toRadians(current.angle)) * current.depth * 10.0);
		int y2 = current.y1 + (int) (Math.sin(Math.toRadians(current.angle)) * current.depth * 10.0);

		g.drawLine(current.x1, current.y1, x2, y2);

		if (current.depth <= 0)
		{
			return;
		}

		objects.add(new TreeObject(x2, y2, current.angle - 40, current.depth - 1));
		objects.add(new TreeObject(x2, y2, current.angle + 40, current.depth - 1));
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		System.out.print("Enter 1 for recursive or 2 for iterative: ");
		Scanner input = new Scanner(System.in);
		int response = input.nextInt();
		if(response == 1)
		{
			drawRecursive(g, 400, 500, -90, 8);
		//	System.out.println("Number of operations: " + (2+2*n+2*n));
			System.out.println("Number of operations: " + counter);
			System.out.println("Time complexity: O(N)");
		}
		else if(response == 2)
		{
			drawIterative(g, 400, 500, -90, 8);
		//	System.out.println("Number of operations: 1 + n * 2n = " + (1 + 8 * (2*8)));
			System.out.println("Number of operations: " + counter);
			System.out.println("Time complexity: O(N^2)");
		}
		else
			System.out.println("Invalid response.");
	}

	private static class TreeObject
	{
		int depth;
		double angle;
		int x1, y1;

		TreeObject(int x1, int y1, double angle, int depth)
		{
			this.depth = depth;
			this.angle = angle;
			this.x1 = x1;
			this.y1 = y1;
		}
	}
}