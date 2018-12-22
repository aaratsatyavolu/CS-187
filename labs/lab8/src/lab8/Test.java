package lab8;

public class Test {
	public static void main(String args[]) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println(list.maxValue()); // should be null
		list.add(20).add(30).add(10);
		System.out.println(list.maxValue()); // should be 30
		list.threshold(40);
		list.print(); // should print out all elements
		list.threshold(30);
		list.print(); // should print out 10 20
		list.threshold(10);
		list.print(); // should print nothing
	}
}
