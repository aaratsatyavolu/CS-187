package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An implementation of a Searcher that performs an iterative search, storing
 * the list of next states in a Queue. This results in a breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {

	private final List<T> visited, predecessors, retrace;
	private final Queue<T> q;

	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		visited = new ArrayList<T>();
		predecessors = new ArrayList<T>();
		retrace = new ArrayList<T>();
		q = new LinkedList<T>();
	}

	@Override
	public List<T> findSolution() {
		if (solution != null) {
			return solution;
		}
		final T init = searchProblem.getInitialState();
		T current = null;
		q.add(init);

		while (!q.isEmpty()) {
			T elem = q.poll();

			if (searchProblem.isGoal(elem)) {
				current = elem;
				break;
			}

			visited.add(elem);

			for (T neighbor : searchProblem.getSuccessors(elem)) {
				if (!visited.contains(neighbor)) {
					q.add(neighbor);
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
