/*Lirik Brucaj
 * 10/17/2018
 * Project 2 MultiThreading Sudoku Checker
 */
package MultiThreadingSudokuCheckerPackage;

import java.io.*;
import java.util.*;

public class ThreadTester {
	static final int SIZE = 9;
	static final int NUMTHREADS = 27;

	public static void main(String[] args) {
		// create 2D array to hold puzzle
		int[][] puzzleMatrix = new int[SIZE][SIZE];
		try {
			matrixFiller(puzzleMatrix);
		} catch (IOException e) {

			e.printStackTrace();
		}
		Result[] checks = new Result[NUMTHREADS];
		for (int i = 0; i < NUMTHREADS; i++) {
			checks[i] = new Result();
		}
		Thread[] threadlist = new Thread[NUMTHREADS];
		for (int i = 0; i < SIZE; i++) {
			threadlist[i] = new Thread(new Row(puzzleMatrix, i, checks[i]));
			threadlist[i + 9] = new Thread(new Column(puzzleMatrix, i, checks[i + 9]));
			threadlist[i + 18] = new Thread(new Box(puzzleMatrix, i, checks[i + 18]));
			threadlist[i].start();
			threadlist[i + 9].start();
			threadlist[i + 18].start();
		}
		try {
			for (int i = 0; i < NUMTHREADS; i++) {
				threadlist[i].join();
			}
		} catch (InterruptedException ie) {
		}

		boolean finalanswer = true;
		for (int i = 0; i < SIZE; i++) {
			if (!checks[i].isCorrect())
				finalanswer = false;
		}
		if (finalanswer)
			System.out.println("The solution is correct!");
		else
			System.out.println("WRONG! ");
	}

	static void matrixFiller(int[][] puzzle) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the file in the resource folder dont forget the .txt: ");
		String fileName = keyboard.nextLine();
		keyboard.close();
		Scanner inputMatrix = null;
		String[] line;
		inputMatrix = new Scanner(new File("resource\\" + fileName));
		int row = 0;
		while (inputMatrix.hasNextLine()) {
			line = inputMatrix.nextLine().split(" ");
			for (int i = 0; i < 9; i++) {
				puzzle[row][i] = Integer.parseInt(line[i]);
			}
			row++;
		}
		inputMatrix.close();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(puzzle[i][j] + " ");
			}
			System.out.println();
		}
	}
}
