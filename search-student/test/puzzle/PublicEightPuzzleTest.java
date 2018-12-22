package puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import search.SearchProblem;

public class PublicEightPuzzleTest {
	@Rule
	public Timeout globalTimeout = new Timeout(500L, TimeUnit.MILLISECONDS);

	private SearchProblem<List<Integer>> solvedPuzzle;
	private SearchProblem<List<Integer>> oneStepPuzzle;
	private SearchProblem<List<Integer>> sPuzzle;
	private final List<Integer> solved = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 });
	private final List<Integer> oneStep = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 0, 7, 8, 6 });
	private final List<Integer> s = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 0, 5, 6, 7 });

	@Before
	public void before() {
		solvedPuzzle = new EightPuzzle(solved);
		oneStepPuzzle = new EightPuzzle(oneStep);
		sPuzzle = new EightPuzzle(s);
	}

	@Test

	public void testInitialState() {
		assertEquals(solved, solvedPuzzle.getInitialState());
		assertEquals(oneStep, oneStepPuzzle.getInitialState());
	}

	@Test

	public void testIsGoalState() {
		assertTrue(solvedPuzzle.isGoal(solved));
		assertTrue(oneStepPuzzle.isGoal(solved));		
	}

	@Test

	public void testIsNotGoalState() {
		List<Integer> solution = Arrays.asList(new Integer[] { 1, 2, 3, 4, 0, 6, 7, 5, 8 });
		List<Integer> solution2 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		EightPuzzle p = new EightPuzzle(solution);
		EightPuzzle p2 = new EightPuzzle(solution2);
		assertFalse(p.isGoal(solution));
		assertFalse(p2.isGoal(solution2));
		assertFalse(sPuzzle.isGoal(s));
	}

	@Test

	public void testSuccessors() {
		List<List<Integer>> successors = oneStepPuzzle.getSuccessors(oneStep);
		assertEquals(3, successors.size());
		assertTrue(successors.contains(solved));
		assertTrue(successors.contains(Arrays.asList(new Integer[] { 1, 2, 0, 4, 5, 3, 7, 8, 6 })));
		assertTrue(successors.contains(Arrays.asList(new Integer[] { 1, 2, 3, 4, 0, 5, 7, 8, 6 })));
	}

}
