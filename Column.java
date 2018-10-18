/*Lirik Brucaj
 * 10/17/2018
 * Project 2 MultiThreading Sudoku Checker
 */
package MultiThreadingSudokuCheckerPackage;

public class Column extends Thread {
	private int[][] array;
	private int column;
	Result answer;

	Column(int[][] arr, int c, Result r) {
		array = arr;
		column = c;
		answer = r;
	}

	public void run() {
		boolean[] numChecker = new boolean[9];
		boolean isCorrect = true;
		for (int i = 0; i <= 8; i++) {
			numChecker[i] = false;
		}
		for (int i = 0; i <= 8; i++) {
			numChecker[array[i][column] - 1] = true;
		}

		for (int i = 0; i <= 8; i++) {
			if (!numChecker[i])
				isCorrect = false;
		}
		answer.setCorrect(isCorrect);
	}
}
