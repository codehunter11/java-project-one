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

public class Cover {
	
	private boolean covered; // if square is covered, true
	private boolean mine; // if square has a mine, true

	public Cover() {
		covered = true; // square starts covered always
		mine = false; // square has no mine by default
	}

	public void setStatus() {
		covered = !covered;
	}

	public boolean getStatus() {
		return covered;
	}

	public void setMine() {
		mine = true;
	}

	public boolean getMine() {
		return mine;
	}
}