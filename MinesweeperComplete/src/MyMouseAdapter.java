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
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter extends MouseAdapter {

	private MineGen minesGrid = new MineGen();
	public static int totalFlags = 10;
	public static boolean gameEnded;

	public void mousePressed (MouseEvent e) 
	{
		Component c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		JFrame myFrame = (JFrame) c;
		MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
		Insets myInsets = myFrame.getInsets();
		int x1 = myInsets.left;
		int y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		int x = e.getX();
		int y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		myPanel.mouseDownGridX = myPanel.getGridX(x, y);
		myPanel.mouseDownGridY = myPanel.getGridY(x, y);

		switch (e.getButton()) {
		case 1: // Left mouse button

			break;
		case 3: // Right mouse button

			// Draw flags
			if ((myPanel.mouseDownGridX >= 0 && myPanel.mouseDownGridX <= 8)
					&& (myPanel.mouseDownGridY >= 0 && myPanel.mouseDownGridY <= 8)) {

				if (minesGrid.isCovered(myPanel.mouseDownGridY, myPanel.mouseDownGridX)) {
						Color currentColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];

					if (currentColor.equals(Color.WHITE)) {
						Color newColor = Color.RED;
						myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
						myPanel.repaint();
						totalFlags--;
					}
					else 
					{
						Color newColor = Color.WHITE;
						myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
						myPanel.repaint();
						totalFlags++;
					}
				}
			}
			break;
		default: // If other button is pressed, do nothing.
			break;
		}
	}

	public void mouseReleased(MouseEvent e)
	{
		switch (e.getButton()) {
		case 1: // Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				// Had pressed outside
				// Do nothing

			} else {
				if ((gridX == -1) || (gridY == -1)) {
					// Is releasing outside
					// Do nothing
				} else {

					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						// Released the mouse button on a different cell where
						// it was pressed
						// Do nothing

					} else {
						// Released the mouse button on the same cell where it
						// was pressed

						if ((gridX >= 0 && gridX <= 8) && (gridY >= 0 && gridY <= 8)) { // This will cover every point on grid.
							//this will uncover the squares and check if the square has a flag
							// if it has a flag it will not uncover
							if (minesGrid.isCovered(gridY, gridX) && myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] != Color.RED) {
								if (minesGrid.hasMine(gridY, gridX))
								{// Check if pressed square has a mine
									endGame(myFrame, myPanel);
								}
								else 
								{
									// If no mine, uncover and give # of closest mines.
									MinesHandler.paintClosest(myPanel, minesGrid, this, gridX, gridY);
									gameEnded = false;
								}
								winGame();
							}
						}	
					}
				}
			}

		case 3: // Right mouse button
			// Do nothing
			break;
		default: // if other button is pressed, do nothing.
			break;
		}
	}
	public void coverSquare(MyPanel myPanel, int gridX, int gridY,
			int adjacentMines) {
		if (minesGrid.isCovered(gridY, gridX)) {
			Color newColor = Color.LIGHT_GRAY;
			myPanel.colorArray[gridX][gridY] = newColor;
			if (adjacentMines != -1) {
				myPanel.drawNumber(adjacentMines, gridX, gridY);
			}
			myPanel.repaint();
			minesGrid.setUncovered(gridY, gridX);
		}
	}
	public void winGame() {
		if (minesGrid.allUncovered()) {
			JOptionPane.showMessageDialog(null, "Congratulations! You Won!");
			System.exit(0);
		}
	}

	public void endGame(JFrame myFrame, MyPanel myPanel) {
		int[][] mines = minesGrid.getMineLocations();
		int mineCount = minesGrid.getMineCount();
		
		gameEnded = true;
		int i;
		for (i = 0; i < mineCount; i++)
			myPanel.colorArray[mines[i][1]][mines[i][0]] = Color.BLACK;
		myPanel.repaint();
		
		JOptionPane.showMessageDialog(null,"Game Over, You've Lost!");
		System.exit(0);
	}
}

