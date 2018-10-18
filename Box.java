/*Lirik Brucaj
 * 10/17/2018
 * Project 2 MultiThreading Sudoku Checker
 */
package MultiThreadingSudokuCheckerPackage;

import java.util.*;
import java.io.*;

// lirik Brucaj
public class Box extends Thread {
	private int[][] array;
	private int box, rowStart, rowEnd, columnStart, columnEnd;
	Result answer;

	Box(int[][] arr, int b, Result r) {
		array = arr;
		box = b;
		answer = r;
	}

	public void run() {
		boolean[] numChecker = new boolean[9];
		findBox();
		boolean isCorrect = true;
		for (int i = 0; i <= 8; i++) {
			numChecker[i] = false;
		}
		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = columnStart; j <= columnEnd; j++) {
				numChecker[(array[i][j] - 1)] = true;
			}
		}
		for (int i = 0; i <= 8; i++) {
			if (!numChecker[i])
				isCorrect = false;
		}
		answer.setCorrect(isCorrect);
	}

	public void findBox() {
		if (box % 3 == 0)
			rowStart = 0;
		else if (box % 3 == 1)
			rowStart = 3;
		else
			rowStart = 6;
		rowEnd = rowStart + 2;
		if (box - 3 <= 0)
			columnStart = 0;
		else if (box - 6 <= 0)
			columnStart = 3;
		else
			columnStart = 6;
		columnEnd = columnStart + 2;
	}
}
