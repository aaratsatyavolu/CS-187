package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PublicRedBlackTreeTest {

	private RedBlackTree<Integer> tree, tree2;

	// @Rule
	// public Timeout timeout = new Timeout(1L, TimeUnit.SECONDS);

	@Before
	public void before() {
		tree = new RedBlackTree<Integer>();
		tree2 = new RedBlackTree<Integer>();
	}

	@Test
	public void testAdd() {
		tree.add(0);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		assertEquals(2, tree.height());
		tree.add(4);
		assertEquals(2, tree.height());
	}

	@Test
	public void testAdd2() {
		tree2.add(0);
		tree2.add(10);
		tree2.add(1);

	}

	@Test
	public void testRemove() {
		for (int i : new int[] { 3, 1, 5, 0, 4, 2, 6 }) {
			tree.add(i);
		}

		for (int i : new int[] { 1, 2, 0, 4 }) {
			tree.remove(i);
		}

		BSTInterface<Integer> smallTree = new BinarySearchTree<Integer>();
		smallTree.add(5);
		smallTree.add(3);
		smallTree.add(6);

		assertTrue(tree.equals(smallTree));
	}
}
