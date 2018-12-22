package structures;

import java.util.Comparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {

	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
	}

	@Override
	protected int getLeftChildOf(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		return 2 * index + 1;
	}

	@Override
	protected int getRightChildOf(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		return 2 * index + 2;
	}

	@Override
	protected int getParentOf(int index) {
		if (index < 1)
			throw new IndexOutOfBoundsException();
		return (index - 1) / 2;
	}

	@Override
	protected void bubbleUp(int index) {
		Entry<P, V> elem = this.heap.get(index);
		int parent = (index - 1) / 2; // getParent(index);
		while ((index > 0) && comparator.compare(elem.getPriority(), heap.get(parent).getPriority()) > 0) {
			heap.set(index, heap.get(parent));
			index = parent;
			parent = (parent - 1) / 2;
		}
		heap.set(index, elem);
	}

	@Override
	protected void bubbleDown(int index) {
		int largerChild;
		Entry<P, V> elem = heap.get(index);
		while (index < heap.size() / 2) {
			int left = 2 * index + 1, right = 2 * index + 2;
			if (right < heap.size()
					&& comparator.compare(heap.get(left).getPriority(), heap.get(right).getPriority()) < 0)
				largerChild = right;
			else
				largerChild = left;
			if (comparator.compare(elem.getPriority(), heap.get(largerChild).getPriority()) >= 0)
				break;
			heap.set(index, heap.get(largerChild));
			index = largerChild;
		}
		heap.set(index, elem);
	}

}
