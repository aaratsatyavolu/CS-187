
public class HeapLab {
	public static void main(String args[]) {
		MaxHeap<Integer> h = new MaxHeap<Integer>(100);
		System.out.println("===Test bubbleUp===");
		h.enqueue(10);
		h.enqueue(20);
		h.enqueue(30);
		System.out.println("Expected: 30 10 20");
		System.out.print("Actual:   ");
		h.print();
		h.enqueue(35);
		h.enqueue(25);
		h.enqueue(15);
		System.out.println("Expected: 35 30 20 10 25 15");
		System.out.print("Actual:   ");
		h.print();
		h.enqueue(50);
		System.out.println("Expected: 50 30 35 10 25 15 20");
		System.out.print("Actual:   ");
		h.print();
		System.out.println("===Test bubbleDown===");
		h.dequeue();
		System.out.println("Expected: 35 30 20 10 25 15");
		System.out.print("Actual:   ");
		h.print();
		h.dequeue();
		System.out.println("Expected: 30 25 20 10 15");
		System.out.print("Actual:   ");
		h.print();
		System.out.println("===Test bubbleUp and Down===");
		h.enqueue(21);
		h.dequeue();
		System.out.println("Expected: 25 20 21 10 15");
		System.out.print("Actual:   ");
		h.print();
		h.enqueue(30);
		h.enqueue(35);
		h.enqueue(40);
		h.enqueue(45);
		h.enqueue(50);
		System.out.println("Expected: 50 45 30 35 40 21 25 10 20 15");
		System.out.print("Actual:   ");
		h.print();
		h.set(0, 5);
		System.out.println("Expected: 45 40 30 35 15 21 25 10 20 5");
		System.out.print("Actual:   ");
		h.print();
		h.set(4, 50);
		System.out.println("Expected: 50 45 30 35 40 21 25 10 20 5");
		System.out.print("Actual:   ");
		h.print();
	}
}
