package structures;

import java.util.Comparator;
import java.util.Iterator;

import comparators.IntegerComparator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {

	protected IntegerComparator comparator = new IntegerComparator();
	protected StudentArrayHeap<Integer, V> maxHeap = new StudentArrayHeap<Integer, V>(comparator);

	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		if (priority == null || value == null)
			throw new NullPointerException();
		maxHeap.add(priority, value);
		return this;
	}

	@Override
	public V dequeue() {
		if (isEmpty())
			throw new IllegalStateException();
		return maxHeap.remove();
	}

	@Override
	public V peek() {
		if (isEmpty())
			throw new IllegalStateException();
		return maxHeap.heap.get(0).getValue();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		return maxHeap.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		return comparator;
	}

	@Override
	public int size() {
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}
