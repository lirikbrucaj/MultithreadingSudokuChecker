/*Lirik Brucaj
 * 10/17/2018
 * Project 2 MultiThreading Sudoku Checker
 */
package MultiThreadingSudokuCheckerPackage;

public class Result {
	private boolean correct;

	Result() {
		this.correct = true;
	}

	public boolean isCorrect() {
		return this.correct;
	}

	public void setCorrect(boolean isCorrect) {
		this.correct = isCorrect;
	}
}
