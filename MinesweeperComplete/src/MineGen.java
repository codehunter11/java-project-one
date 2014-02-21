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

import java.util.Random;
 
public class MineGen {
	//This class creates a grid to handle the mines inside squares.
	
	private Random generator;
	private int row;
	private int column;
	private int gridSize;
	private Cover[][] grid;
	private int mineLocationSize;
	private int[][] mineLocation;
	private int coveredSquares;


	public MineGen() {

		generator = new Random();
		gridSize = MyPanel.getTotalColumns(); 
		row = generator.nextInt(gridSize);
		column = generator.nextInt(gridSize);
		grid = new Cover[gridSize][gridSize];
		mineLocation = new int[gridSize + 1][2];
		mineLocationSize = 0;
		coveredSquares = (gridSize * gridSize) - getMineCount();
		squaresInit(); // Fill grid with squares.

		for (int i = 0; i < gridSize + 1; i++) {  // Randomly place Mines across the grid.
			newMineLocation();
			grid[row][column].setMine();
			mineLocation[i][0] = row; // We store the mine location here.
			mineLocation[i][1] = column; //We store  the mine location here.
			mineLocationSize++; // We return the mine location size.
		}
	}

	private void squaresInit() { 
		for (int i = 0; i < gridSize; i++) // Squares are initialized and covered.
			for (int j = 0; j < gridSize; j++)
				grid[i][j] = new Cover();
	}

	private void newMineLocation() {
		row = generator.nextInt(gridSize); // Generate a mine location randomly.
		column = generator.nextInt(gridSize);

		int step = 0; 	// We make sure  the mine is in a non repeated position.
		while (step != mineLocationSize) {
			for (int j = 0; j < mineLocationSize; j++) // If mine is located where other is stored it chooses another place.
				if (row == mineLocation[j][0] && column == mineLocation[j][1]) {
					row = generator.nextInt(gridSize);
					column = generator.nextInt(gridSize);
					step = 0;
					break;
				}
			
				else
					step++; // Variable increases until it reaches the value of mineLocationSize.
		}
	}

	public boolean isCovered(int x, int y) { // Checks if a square is covered.
		return grid[x][y].getStatus(); 
	}

	public void setUncovered(int x, int y) {  // Uncovered squares status.
		grid[x][y].setStatus();
		coveredSquares--;
	}

	public boolean allUncovered() {
		if (coveredSquares == 0) // Checks if squares are uncovered.
			return true;
		return false;
	}

	public boolean hasMine(int x, int y) { // Checks if square has a mine.
		return grid[x][y].getMine();
	}

	public int adjacentMines(int gridX, int gridY) { // Detects where the number is acording to mine location. 
		// Left Column
		if ((gridX == 0) && ((gridY >= 1) && (gridY < 8))) {
			return MineSearcher.leftColumn(this, gridX, gridY);
		}

		// Right Column
		else if ((gridX == 8) && ((gridY >= 1) && (gridY < 8))) {
			return MineSearcher.rightColumn(this, gridX, gridY);
		}

		// Top Row
		else if ((gridY == 0) && ((gridX > 0) && (gridX < 8))) {
			return MineSearcher.topRow(this, gridX, gridY);
		}

		// Bottom Row
		else if ((gridY == 8) && ((gridX > 0) && (gridX < 8))) {
			return MineSearcher.bottomRow(this, gridX, gridY);
		}

		// Top Left Corner
		else if ((gridX == 0) && (gridY == 0)) {
			return MineSearcher.topLeftCorner(this, gridX, gridY);
		}

		// Bottom Left Corner
		else if ((gridX == 0) && (gridY == 8)) {
			return MineSearcher.bottomLeftCorner(this, gridX, gridY);
		}

		// Top Right Corner
		else if ((gridX == 8) && (gridY == 0)) {
			return MineSearcher.topRightCorner(this, gridX, gridY);
		}

		// Bottom Right Corner
		else if ((gridX == 8) && (gridY == 8)) {
			return MineSearcher.bottomRightCorner(this, gridX, gridY);
		}

		// Overall grid
		else {
			return MineSearcher.overallMines(this, gridX, gridY);
		}
	}

	public int[][] getMineLocations() {
		return mineLocation;
	}

	public int getMineCount() {
		return gridSize + 1;
	}
}