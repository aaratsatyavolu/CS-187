package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;

/**
 * An iterator to perform a level order traversal of part of a filesystem. A
 * level-order traversal is equivalent to a breadth- first search.
 */
public class LevelOrderIterator extends FileIterator<File> {

	public Queue<File> q = new Queue<File>();

	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * 
	 * @param rootNode
	 * @throws FileNotFoundException
	 *             if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
		if (!rootNode.exists())
			throw new FileNotFoundException();
		q.enqueue(rootNode);
	}

	@Override
	public boolean hasNext() {
		return !q.isEmpty();
	}

	@Override
	public File next() throws NoSuchElementException {
		if (!hasNext())
			throw new NoSuchElementException();

		File file = q.peek();

		if (file.isDirectory()) {
			File[] f = file.listFiles();
			Arrays.sort(f);
			for (int i = 0; i < f.length; i++) {
				q.enqueue(f[i]);
			}
		}
		q.dequeue();
		return file;
	}

	@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();
	}

}
