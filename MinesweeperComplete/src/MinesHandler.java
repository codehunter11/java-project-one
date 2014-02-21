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

public class MinesHandler {
	
	// This class explores the area and discovers the explored areas.
	// We here use recursion.

	public static boolean exploredArea = false;

	public static void paintClosest(MyPanel myPanel, MineGen theGrid, MyMouseAdapter mouseAdapter, int gridX, int gridY) {
		
		// Left Column
		if ((gridX == 0) && (gridY >= 1 && gridY < 8)) {

			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);
				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1,gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1,gridY - 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Right Column
		else if ((gridX == 8) && ((gridY >= 1) && (gridY < 8))) {

			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1,
						gridY - 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Top Row
		else if ((gridY == 0) && ((gridX > 0) && (gridX < 8))) {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY + 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Bottom Row
		else if ((gridY == 8) && ((gridX > 0) && (gridX < 8))) {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY - 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Top Left Corner
		else if ((gridX == 0) && (gridY == 0)) {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY + 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Bottom Left Corner
		else if ((gridX == 0) && (gridY == 8)) {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY - 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Top Right Corner
		else if ((gridX == 8) && (gridY == 0)) {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY + 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Bottom Right Corner
		else if ((gridX == 8) && (gridY == 8)) {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY - 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}

		// Overall Grid
		else {
			if ((theGrid.adjacentMines(gridX, gridY) == 0) && theGrid.isCovered(gridY, gridX)) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, -1);

				// Discover all adjacent squares
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY - 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX - 1, gridY + 1);
				paintClosest(myPanel, theGrid, mouseAdapter, gridX + 1, gridY + 1);
				if (!exploredArea)
					exploredArea = true;
			}

			else if (theGrid.adjacentMines(gridX, gridY) > 0) {
				mouseAdapter.coverSquare(myPanel, gridX, gridY, theGrid.adjacentMines(gridX, gridY));
			}

			else
				return;
		}
		myPanel.repaint();
	}

	public static boolean exploredArea() {
		return exploredArea;
	}

	public static void exploredAreaReset() {
		exploredArea = !exploredArea;
	}
}
