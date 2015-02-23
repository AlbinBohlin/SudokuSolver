package sudukoTest;

import sudukoSolver.Last;
import sudukoSolver.SudokuGUI;

public class TestLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Last sudukosolver=new Last();
SudokuGUI gui=new SudokuGUI();
sudukosolver.solve(0, 0);
sudukosolver.printSudoku();

	}

}
