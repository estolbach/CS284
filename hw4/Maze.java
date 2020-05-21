package Maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

import javax.swing.JComponent;

/**
 * Class that solves maze problems with backtracking.
 * 
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

	/** The maze */
	private TwoDimGrid maze;

	public Maze(TwoDimGrid m) {
		maze = m;
	}

	/** Wrapper method. */
	public boolean findMazePath() {
		// return findMazePath(0, 0); // (0, 0) is the start point.
		ArrayList<ArrayList<PairInt>> n = findAllMazePaths(0, 0);
		if (n != null)
			return true;
		return false;
	}

	/**
	 * Attempts to find a path through point (x, y).
	 * 
	 * @pre Possible path cells are in BACKGROUND color; barrier cells are in
	 *      ABNORMAL color.
	 * @post If a path is found, all cells on it are set to the PATH color; all
	 *       cells that were visited but are not on the path are in the
	 *       TEMPORARY color.
	 * @param x
	 *            The x-coordinate of current point
	 * @param y
	 *            The y-coordinate of current point
	 * @return If a path through (x, y) is found, true; otherwise, false
	 */
	public boolean findMazePath(int x, int y) {
		if (maze.getNCols() <= x || maze.getNRows() <= y || x < 0 || y < 0) {
			return false;
		}
		if (maze.getColor(x, y) != NON_BACKGROUND) {
			return false;
		}
		if (maze.getNCols() - 1 == x && maze.getNRows() - 1 == y) {
			maze.recolor(x, y, PATH);
			return true;
		}
		maze.recolor(x, y, PATH);
		if (findMazePath(x - 1, y) || findMazePath(x + 1, y)
				|| findMazePath(x, y - 1) || findMazePath(x, y + 1)) {			
			return true;
		}
		return false;
	}

	/**
	 * this is a helper method to find all possible paths
	 * 
	 * @param x
	 * @param y
	 * @param result
	 * @param trace
	 */
	public void findMazePathStackBased(int x, int y,
			ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		if (maze.getNCols() <= x || maze.getNRows() <= y || x < 0 || y < 0) {
			return;
		}
		if (maze.getColor(x, y) != ABNORMAL) {
			return;
		}
		if (maze.getNCols() - 1 == x && maze.getNRows() - 1 == y) {
			maze.recolor(x, y, PATH);
			PairInt pair = new PairInt(x, y);
			trace.push(pair);
			ArrayList<PairInt> temp = new ArrayList<PairInt>();
			temp.addAll(trace);
			result.add(temp);
			
		}

		maze.recolor(x, y, PATH);
		PairInt pair0 = new PairInt(x, y);
		trace.push(pair0);
		findMazePathStackBased(x - 1, y, result, trace);
		findMazePathStackBased(x + 1, y, result, trace);
		findMazePathStackBased(x, y - 1, result, trace);
		findMazePathStackBased(x, y + 1, result, trace);

		//backtracking
		if (x - 1 > 0 && maze.getColor(x-1, y) == PATH) {
			trace.pop();
			maze.recolor(x - 1, y, NON_BACKGROUND);
		}
		if (x + 1 < maze.getNCols() && maze.getColor(x+1, y) == PATH) {
			trace.pop();
			maze.recolor(x + 1, y, NON_BACKGROUND);
		}
		if (y - 1 > 0 && maze.getColor(x, y-1) == PATH) {
			trace.pop();
			maze.recolor(x, y - 1, NON_BACKGROUND);

		}
		if (y + 1 < maze.getNRows() && maze.getColor(x, y+1) == PATH) {
			trace.pop();
			maze.recolor(x, y + 1, NON_BACKGROUND);
		}
	}

	/**
	 * this method finds all possible paths in the maze
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
		ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
		Stack<PairInt> trace = new Stack<>();
		findMazePathStackBased(0, 0, result, trace);
		return result;
	}

	/**
	 * this method returns the shortest path
	 * 
	 * @param x
	 * @param y
	 * @return newResult
	 */
	public ArrayList<PairInt> findMazePathMin(int x, int y) {
		int min = maze.getNCols() * maze.getNRows();
		ArrayList<PairInt> newResult = new ArrayList<>();
		ArrayList<ArrayList<PairInt>> result = findAllMazePaths(x, y);
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).size() < min) {
				newResult = result.get(i);
				min = result.get(i).size();
			}
		}
		return newResult;
	}

	/* <exercise chapter="5" section="6" type="programming" number="2"> */
	public void resetTemp() {
		maze.recolor(TEMPORARY, BACKGROUND);
	}

	/* </exercise> */

	/* <exercise chapter="5" section="6" type="programming" number="3"> */
	public void restore() {
		resetTemp();
		maze.recolor(PATH, BACKGROUND);
		maze.recolor(NON_BACKGROUND, BACKGROUND);
	}
	/* </exercise> */
}
/* </listing> */
