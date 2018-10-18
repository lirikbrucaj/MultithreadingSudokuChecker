/*Lirik Brucaj
 * 10/17/2018
 * Project 2 MultiThreading Sudoku Checker
 */
package MultiThreadingSudokuCheckerPackage;

public class Row extends Thread {
	private int[][] array;
	private int row;
	Result answer;

	Row(int[][] arr, int rowNum, Result r) {
		array = arr;
		row = rowNum;
		answer = r;
	}

	public void run() {
		boolean[] numChecker = new boolean[9];
		boolean isCorrect = true;
		for (int i = 0; i <= 8; i++) {
			numChecker[i] = false;
		}
		for (int i = 0; i <= 8; i++) {
			numChecker[array[row][i] - 1] = true;
		}
		for (int i = 0; i <= 8; i++) {
			if (!numChecker[i])
				isCorrect = false;
		}
		answer.setCorrect(isCorrect);
	}
}
