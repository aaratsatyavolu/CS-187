package structures;

import java.util.Comparator;
import java.util.Iterator;

import comparators.ReverseIntegerComparator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {

	protected ReverseIntegerComparator comparator = new ReverseIntegerComparator();
	protected StudentArrayHeap<Integer, V> minHeap = new StudentArrayHeap<Integer, V>(comparator);

	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		if (priority == null || value == null)
			throw new NullPointerException();
		minHeap.add(priority, value);
		return this;
	}

	@Override
	public V dequeue() {
		if (isEmpty())
			throw new IllegalStateException();
		return minHeap.remove();
	}

	@Override
	public V peek() {
		if (isEmpty())
			throw new IllegalStateException();
		return minHeap.heap.get(0).getValue();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		return minHeap.asList().iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		return comparator;
	}

	@Override
	public int size() {
		return minHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}
