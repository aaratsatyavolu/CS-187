package midterm2;

import java.util.LinkedList;
import java.util.Queue;


public class testQueue {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.add("D");
		q.add("A");
		q.poll();
		q.add("B");
		q.add("C");
		q.poll();
		System.out.println(q.poll());
	}
}
