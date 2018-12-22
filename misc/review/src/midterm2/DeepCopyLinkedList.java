package midterm2;

import java.util.LinkedList;

public class DeepCopyLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);

		for (Integer i : list1) {
			list2.add(new Integer(i));
		}
	}
}
