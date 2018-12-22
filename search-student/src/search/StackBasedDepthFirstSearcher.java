package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search, storing
 * the list of next states in a Stack. This results in a depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {

	private final List<T> visited, predecessors, retrace;
	private final Stack<T> s;

	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		visited = new ArrayList<T>();
		predecessors = new ArrayList<T>();
		retrace = new ArrayList<T>(); // retrace
		s = new Stack<T>();
	}

	@Override
	public List<T> findSolution() {
		if (solution != null) {
			return solution;
		}
		final T init = searchProblem.getInitialState();
		T current = null;
		s.push(init);

		while (!s.isEmpty()) {
			T elem = s.pop();

			if (searchProblem.isGoal(elem)) {
				current = elem;
				break;
			}

			visited.add(elem);

			for (T neighbor : searchProblem.getSuccessors(elem)) {
				if (!visited.contains(neighbor)) {
					s.push(neighbor);
					retrace.add(neighbor);
					predecessors.add(elem);
				}

			}
		}
		final List<T> path = new ArrayList<T>();

		// if a goal was found
		if (current != null) {
			// build a path by looking up each predecessor, starting from
			// the goal state
			path.add(current);
			while (!current.equals(searchProblem.getInitialState())) {
				final T predecessor = predecessors.get(retrace.indexOf(current));
				path.add(predecessor);
				current = predecessor;
			}

			// the path is in reverse order (goal-to-initial), so we reverse
			// it into the correct order
			Collections.reverse(path);
		}
		if (path.size() > 0) {
			if (!isValidSolution(path)) {
				throw new RuntimeException("searcher should never find an invalid solution!");
			}
		}
		return path;
	}
}
