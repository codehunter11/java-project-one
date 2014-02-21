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

import javax.swing.JFrame;

public class Main 
{
	public static void main(String[] args) 
	{
		JFrame myFrame = new JFrame("Minesweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(290, 370);

		MyPanel myPanel = new MyPanel();
		myFrame.add(myPanel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
		myFrame.setResizable(false);
	}
}
