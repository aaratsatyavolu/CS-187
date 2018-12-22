package puzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2 --+---+--- 3 | 4 | 5 --+---+--- 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space. If we
 * represent the empty space as 0, then the puzzle is solved when the values in
 * the puzzle are as follows:
 * 
 * 1 | 2 | 3 --+---+--- 4 | 5 | 6 --+---+--- 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space at index 1
 * contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space adjacent to
 * it (that is, above, below, left, or right of it, without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap it with the value
 * at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle for details.
 * 
 * 
 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {

	public List<Integer> start;

	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 */
	public EightPuzzle(List<Integer> startingValues) {
		if (startingValues.size() != 9 || startingValues == null)
			throw new IllegalArgumentException();
		this.start = startingValues;
	}

	@Override
	public List<Integer> getInitialState() {
		return start;
	}

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		List<List<Integer>> successors = new LinkedList<List<Integer>>();
		List<Integer> l = new LinkedList<Integer>(), l2 = new LinkedList<Integer>();
		List<Integer> l3 = new LinkedList<Integer>(), l4 = new LinkedList<Integer>();
		for (int i = 0; i < 9; i++) {
			l.add(currentState.get(i));
			l2.add(currentState.get(i));
			l3.add(currentState.get(i));
			l4.add(currentState.get(i));
		}
		int indexSpace = currentState.indexOf(0);

		// check indexSpace to set up and down to 0 preemtively
		int left = indexSpace - 1, right = indexSpace + 1;
		int up = indexSpace - 3, down = indexSpace + 3;

		if (indexSpace == 3 || indexSpace == 6)
			left = -1;
		if (indexSpace == 2 || indexSpace == 5 || indexSpace == 8)
			right = -1;

		if (left >= 0 && left <= 7) {
			l.set(indexSpace, l.get(left));
			l.set(left, 0);
			successors.add(l);
		}
		if (right >= 1 && right <= 8) {
			l2.set(indexSpace, l2.get(right));
			l2.set(right, 0);
			successors.add(l2);
		}

		if (up >= 0 && up <= 5) {
			l3.set(indexSpace, l3.get(up));
			l3.set(up, 0);
			successors.add(l3);
		}
		if (down >= 3 && down <= 8) {
			l4.set(indexSpace, l4.get(down));
			l4.set(down, 0);
			successors.add(l4);
		}

		return successors;
	}

	@Override
	public boolean isGoal(List<Integer> state) {
		if (state.size() != 9 || state.indexOf(0) == -1)
			return false;
		List<Integer> solution = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 0}); 
		for (int i  = 0; i < state.size(); i++) {
			if (state.get(i) != solution.get(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3, 4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
