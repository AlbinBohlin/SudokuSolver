package sudukoSolver;

import java.util.Arrays;

public class Last {

	private int[][] grid;

	public Last() {
		grid = new int[9][9];

	}

	public int getValue(int row, int column) {
		return grid[row][column];
	}

	public void setValue(int newValue, int row, int column) {
		grid[row][column] = newValue;
	}

	public boolean solve(int row, int column) {

		for (int i = 1; i < 10; i++) {
			if (solve(i, row, column))
				return true;
		}

		return false;
	}

	private boolean solve(int nbr, int row, int column) {
		if (compliance(nbr, row, column)) {
			setValue(nbr, row, column);
			if (column == 8 && row != 8) {
				column = -1;
				row += 1;
			}
			if (column == 8 && row == 8) {printSudoku(); return true;}
			
			if (solve(row, column + 1))
				return true;
		}
		return false;
	}

	// /* first, check if inputdata has number. */
	// if (SudokuGUI.entryData[row][column] != 0) {
	// if (compliance(SudokuGUI.entryData[row][column], row, column)) {
	// if (column == 8 && row != 8) {
	// column = -1;
	// row += 1;
	// }
	// solve(row, column +1);
	// } else
	// return false;
	// } else {
	// for (int i = 1; i < 10; i++) {
	// if (compliance(i, row, column)) {
	// setValue(i, row, column);break;
	//
	// }else if(i==9)return false;
	//
	// }
	//
	//
	//
	// if (column == 8 && row != 8) {
	// column = -1;
	// row += 1;
	// }
	//
	// if (solve(row, column+1 )){
	// return true;}
	//
	// return false;
	// }
	// printSudoku();
	// return true;
	// }

	/*
	 * checks if the current digit we´re trying is in compliance with rules. if
	 * true current digit resets, if false we try next digit.(letstrynext checks
	 * for no more digits to try.)
	 */
	private boolean compliance(int n, int row, int column) {
		int tmp = 0;
		// since complies () does´nt diffirentiate on checking for allready
		// filled
		// pos or empty pos i make it temporarely empty.
		if (grid[row][column] > 0) {
			tmp = grid[row][column];
			grid[row][column] = 0;
		}
		// three rules for comply, no same digit in region, no same digit in
		// row, no same digit in column
		if (regionComplies(n, row, column) && columnComplies(n, column)
				&& rowComplies(n, row)) {

			// and reenter value in current pos if it changed above;
			if (tmp != 0) {
				setValue(tmp, row, column);
			}
			return true;
		} else {
			// letsTryNext();
			return false;
		}

	}

	// determine witch of 9 regions the current number belongs to; check that
	// region for equal numberValue

	private boolean regionComplies(int n, int row, int column) {
		// determines witch region we´re in
		int r = ((row) / 3);
		int c = (column) / 3;
		int region = (r - 1) * 3 + c;
		// checks that region for duplicate number.
		for (int i = 0 + 3 * r; i < 3 + 3 * r; i++) {
			for (int j = 0 + 3 * c; j < 3 + 3 * c; j++) {
				if (grid[i][j] == n) {
					return false;
				}
			}

		}

		return true;
	}

	// check all elements in cRow for same number.
	private boolean rowComplies(int n, int row) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[row][i] == n)
				return false;
		}
		return true;
	}

	// check column for same number on different row.
	private boolean columnComplies(int n, int column) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][column] == n)
				return false;
		}
		return true;
	}

	public void printSudoku() {
		System.out.println();
		for (int j = 0; j < grid.length; j++) {

			System.out.println(Arrays.toString(grid[j]));
		}
		System.out.println();
	}

}
