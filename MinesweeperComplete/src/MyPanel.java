/*
 
 Team Name: CodeHunters
 Team Members/GitHub Username: 
 Laura Rivera Rodriguez / laura-rivera21
 Eliel Ruiz Rodriguez / codehunter11
 
 Project01: Minesweeper
 Course: ICOM4015
 Professor: Dr. Bienvenido Velez
 Due Date: October 22, 2013
 
 */ 


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JPanel;


public class MyPanel extends JPanel 
{
	private static final long serialVersionUID = 3426940946811133635L;
	private static final int GRID_X = 5;
	private static final int GRID_Y = 5;
	private static final int INNER_CELL_SIZE = 30;
	private int numPosition = 0;
	private int[][] numbers = new int[(getTotalColumns() * TOTAL_ROWS)][3];
	private static final int TOTAL_COLUMNS = 9;
	private static final int TOTAL_ROWS = 9;  
	public int x = -1;
	public int y = -1;
	public int mouseDownGridX = 0;
	public int mouseDownGridY = 0;
	public Color[][] colorArray = new Color[getTotalColumns()][TOTAL_ROWS];
	public Random generator;
	public int thisManyBombs = 10;	
	
	public MyPanel() {  
		for (int x = 0; x < getTotalColumns(); x++) 
		{   //The rest of the grid
			for (int y = 0; y < TOTAL_ROWS; y++) 
			{
				colorArray[x][y] = Color.WHITE;
			}
		}
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		//Compute interior coordinates
		Insets myInsets = getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		int x2 = getWidth() - myInsets.right - 1;
		int y2 = getHeight() - myInsets.bottom - 1;
		int width = x2 - x1;
		int height = y2 - y1;

		
		//Paint the background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x1, y1, width + 1, height + 1);
		
		//draw horizontal lines of the grid
		g.setColor(Color.BLACK);
		for (int y = 0; y <= TOTAL_ROWS; y++)
		{
			g.drawLine(x1 + GRID_X , y1 + GRID_Y + (y * (INNER_CELL_SIZE + 1)), x1 + GRID_X + ((INNER_CELL_SIZE + 1) * getTotalColumns()), y1 + GRID_Y + (y * (INNER_CELL_SIZE + 1)));
		}
		
		//draw vertical lines of the grid
		for (int x = 0; x <= getTotalColumns(); x++) 
		{
			g.drawLine(x1 + GRID_X + (x * (INNER_CELL_SIZE + 1)), y1 + GRID_Y, x1 + GRID_X + (x * (INNER_CELL_SIZE + 1)), y1 + GRID_Y + ((INNER_CELL_SIZE + 1) * (TOTAL_ROWS)));
		}

		//Paint cell colors
		for (int x = 0; x < getTotalColumns(); x++) 
		{
			for (int y = 0; y < TOTAL_ROWS; y++) 
			{
				if ((x == 0) || (y != TOTAL_ROWS)) 
				{
					Color c = colorArray[x][y];
					g.setColor(c);
					g.fillRect(x1 + GRID_X + (x * (INNER_CELL_SIZE + 1)) + 1, y1 + GRID_Y + (y * (INNER_CELL_SIZE + 1)) + 1, INNER_CELL_SIZE, INNER_CELL_SIZE);
				}
			}
		}
		
		// display flags counter
		int flags = MyMouseAdapter.totalFlags;
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("default", Font.BOLD, 16));
		g2.drawString("Flags: "+flags, 30, 310);

		
		if (!MyMouseAdapter.gameEnded)
		{	
		// Happy Face
		g2.setColor(Color.YELLOW);
		g2.fillOval(129, 295, 35, 35);
		g2.setColor(Color.BLACK);
		g2.fillOval(139, 305, 3, 3);
		g2.fillOval(150, 305, 3, 3);
		g2.drawArc(136, 305, 20, 20, 0, -180);
		}
		
		else
		{
		// Sad Face
		g2.setColor(Color.YELLOW);
		g2.fillOval(129, 295, 35, 35);
		g2.setColor(Color.BLACK);
		g2.fillOval(139, 305, 3, 3);
		g2.fillOval(150, 305, 3, 3);
		g2.drawArc(136, 312, 20, 20, 0, 180);
		}
			
		
		// Paint numbers
		for (int i = 0; i < numPosition; i++) {
			int gridX = ((2 * (GRID_X + ((INNER_CELL_SIZE + 1) * numbers[i][1]))) + (INNER_CELL_SIZE + 1)) / 2;
			int gridY = ((2 * (GRID_Y + ((INNER_CELL_SIZE + 1) * numbers[i][2]))) + (INNER_CELL_SIZE + 1)) / 2;
			
			g2.setFont(new Font("default", Font.BOLD, 16));
		
			if ((numbers[i][0]) == 1)
			{
				g2.setColor(Color.BLUE);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 2)
			{
				g2.setColor(Color.MAGENTA);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 3)
			{
				g2.setColor(Color.RED);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 4)
			{
				g2.setColor(Color.DARK_GRAY);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 5)
			{
				g2.setColor(Color.GREEN);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 6)
			{
				g2.setColor(Color.ORANGE);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 7)
			{
				g2.setColor(Color.CYAN);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
			else if ((numbers[i][0]) == 8)
			{
				g2.setColor(Color.PINK);
				g2.drawString(Integer.toString(numbers[i][0]), gridX - 2, gridY + 5);
			}
		}	
	}
	
	public int getGridX(int x, int y) 
	{
		Insets myInsets = getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		x = x - x1 - GRID_X;
		y = y - y1 - GRID_Y;
		if (x < 0) 
		{   //To the left of the grid
			return -1;
		}
		else if (y < 0) 
		{   //Above the grid
			return -1;
		}
		else if ((x % (INNER_CELL_SIZE + 1) == 0) || (y % (INNER_CELL_SIZE + 1) == 0)) 
		{   //Coordinate is at an edge; not inside a cell
			return -1;
		}
		
		x = x / (INNER_CELL_SIZE + 1);
		y = y / (INNER_CELL_SIZE + 1);

		if (x < 0 || x > getTotalColumns() - 1 || y < 0 || y > TOTAL_ROWS - 1) 
		{   //Outside the rest of the grid
			return -1;
		}
		return x;
	}
	
	public int getGridY(int x, int y) 
	{
		Insets myInsets = getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		x = x - x1 - GRID_X;
		y = y - y1 - GRID_Y;
		if (x < 0) 
		{   //To the left of the grid
			return -1;
		}
		else if (y < 0) 
		{   //Above the grid
			return -1;
		}
		else if ((x % (INNER_CELL_SIZE + 1) == 0) || (y % (INNER_CELL_SIZE + 1) == 0)) 
		{   //Coordinate is at an edge; not inside a cell
			return -1;
		}
		x = x / (INNER_CELL_SIZE + 1);
		y = y / (INNER_CELL_SIZE + 1);

		if (x < 0 || x > getTotalColumns() - 1 || y < 0 || y > TOTAL_ROWS - 1) 
		{   //Outside the rest of the grid
			return -1;
		}
		return y;
	}
	
	public void drawNumber(int num, int x, int y) {
		
		numbers[numPosition][0] = num ;
		numbers[numPosition][1] = x;
		numbers[numPosition][2] = y;
		numPosition++;
	}

	public static int getTotalColumns() {
		return TOTAL_COLUMNS;
	}
	
}
