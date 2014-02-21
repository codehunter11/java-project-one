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

public class MineSearcher {
	// As the name of the class says this class search for the mines near the squares, so then we can count them
	// using counters by rows and columns.
	
	
	public static int leftColumn(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of a square that is on the left column
		// and returns the number of its closest mines
		
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a + 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a))
			mineCount++;

		if (theGrid.hasMine(b + 1, a + 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a))
			mineCount++;

		if (theGrid.hasMine(b - 1, a + 1))
			mineCount++;

		return mineCount;
	}
	
	public static int rightColumn(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of a square that is on the right column
		// and returns the number of its closest mines.
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a - 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a))
			mineCount++;

		if (theGrid.hasMine(b + 1, a - 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a))
			mineCount++;

		if (theGrid.hasMine(b - 1, a - 1))
			mineCount++;

		return mineCount;
	}

	public static int topRow(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of a square that is on the top row
		// and returns the number of its closest mines
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a - 1))
			mineCount++;

		if (theGrid.hasMine(b, a + 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a))
			mineCount++;

		if (theGrid.hasMine(b + 1, a + 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a - 1))
			mineCount++;

		return mineCount;
	}

	public static int bottomRow(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of a square that is on the bottom row
		// and returns the number of its closest mines
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a - 1))
			mineCount++;

		if (theGrid.hasMine(b, a + 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a))
			mineCount++;

		if (theGrid.hasMine(b - 1, a + 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a - 1))
			mineCount++;

		return mineCount;
	}

	public static int topLeftCorner(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of the square that is on the top left corner
		// and returns the number of its closest mines.
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a + 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a))
			mineCount++;
		
		if (theGrid.hasMine(b + 1, a + 1))
			mineCount++;

		return mineCount;
	}

	public static int bottomLeftCorner(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of the square that is on the bottom left corner
		// and returns the number of its closest mines.
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a + 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a))
			mineCount++;

		if (theGrid.hasMine(b - 1, a + 1))
			mineCount++;

		return mineCount;
	}

	public static int topRightCorner(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of the square that is on the top right corner
		// and returns the number of its closest mines.
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a - 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a))
			mineCount++;

		if (theGrid.hasMine(b + 1, a - 1))
			mineCount++;

		return mineCount;
	}

	public static int bottomRightCorner(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of the square that is on the bottom right corner
		// and returns the number of its closest mines.
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b - 1, a))
			mineCount++;

		if (theGrid.hasMine(b, a - 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a - 1))
			mineCount++;

		return mineCount;
	}

	public static int overallMines(MineGen theGrid, int gridX, int gridY) {
		// This method receives the coordinates of the square that is on the overall grid
		// and returns the number of its closest mines.
		int a = gridX;
		int b = gridY;
		int mineCount = 0;

		if (theGrid.hasMine(b, a + 1))
			mineCount++;

		if (theGrid.hasMine(b, a - 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a))
			mineCount++;

		if (theGrid.hasMine(b - 1, a))
			mineCount++;

		if (theGrid.hasMine(b + 1, a + 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a + 1))
			mineCount++;

		if (theGrid.hasMine(b + 1, a - 1))
			mineCount++;

		if (theGrid.hasMine(b - 1, a - 1))
			mineCount++;

		return mineCount;
	}
}