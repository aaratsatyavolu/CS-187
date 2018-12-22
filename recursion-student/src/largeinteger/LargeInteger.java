package largeinteger;

import largeinteger.LLNode;

/**
 * The LargeInteger class This class represents a large, non-negative integer
 * using a linked list. Each node stores a single digit. The nodes represent all
 * digits in *reverse* order: the least significant digit is the first node, and
 * the most significant the last node. For example, 135642 is represented as
 * 2->4->6->5->3->1 in that order.
 */
public class LargeInteger {
	private LLNode<Integer> head; // head of the list
	private int size; // size (i.e. number of digits)
	private String num = "";

	// Returns size
	public int size() {
		return size;
	}

	// Returns the linked list (used only for JUnit test purpose)
	public LLNode<Integer> getList() {
		return head;
	}

	public LargeInteger() {
		head = null;
		size = 0;
	}

	/**
	 * Constructor that takes a String as input and constructs the linked list. You
	 * can assume that the input is guaranteed to be valid: i.e. every character in
	 * the string is between '0' and '9', and the first character is never '0'
	 * (unless '0' is the only character in the string). You can use
	 * input.charAt(i)-'0' to convert the character at index i to the integer value
	 * of that digit. Remember: the list nodes must be in reverse order as the
	 * characters in the string.
	 */
	public LargeInteger(String input) {
		for (int i = 0; i < input.length(); i++) {
			LLNode<Integer> n = new LLNode<Integer>(input.charAt(i) - '0', null);
			n.link = head;
			head = n;
			size++;
		}
	}

	/**
	 * Divide *this* large integer by 10 and return this. Assume integer division:
	 * for example, 23/10 = 2, 8/10 = 0 and so on.
	 */
	public LargeInteger divide10() {
		if (size == 0 || size == 1) {
			head = new LargeInteger("0").head;
			return this;
		}
		head = head.link;
		size--;
		return this;
	}

	/**
	 * Multiply *this* large integer by 10 and return this. For example, 23*10 =
	 * 230, 0*10 = 0 etc.
	 */
	public LargeInteger multiply10() {
		if (size == 1 && head.data == 0) {
			return this;
		}
		LLNode<Integer> n = new LLNode<Integer>(0, null);
		n.link = head;
		head = n;
		size++;
		return this;
	}

	/**
	 * Returns a *new* LargeInteger object representing the sum of this large
	 * integer and another one (given by that). Your code must correctly handle
	 * cases such as the two input integers have different sizes (e.g. 2+1000=1002),
	 * or there is a carry over at the highest digit (e.g. 9999+2=10001).
	 */
	public LargeInteger add(LargeInteger that) {

		LargeInteger newInt = new LargeInteger();

		LLNode<Integer> node = this.head, node2 = that.head, tail = null;

		int carry = 0;

		while (node != null || node2 != null) {

			Integer add = (node == null) ? 0 : node.data;
			Integer addend = (node2 == null) ? 0 : node2.data;
			int sum = add + addend + carry;

			LLNode<Integer> newNode = new LLNode<Integer>((sum) % 10, null);
			carry = sum / 10;
			if (tail == null)
				newInt.head = newNode;
			else
				tail.link = newNode;
			tail = newNode;

			if (node != null)
				node = node.link;
			if (node2 != null)
				node2 = node2.link;

			newInt.size++;
		}

		if (carry != 0) {
			tail.link = new LLNode<Integer>(carry, null);
			newInt.size++;
		}

		return newInt;
	}

	/**
	 * Returns a new LargeInteger object representing the result of multiplying this
	 * large integer with a non-negative integer x. You can assume x is either a
	 * positive integer or 0. Hint: you can use a loop and call the 'add' method
	 * above to accomplish the 'multiply'.
	 */
	public LargeInteger multiply(int x) {

		LargeInteger newInt = new LargeInteger();

		if (x == 0)
			return new LargeInteger("0");

		LLNode<Integer> node = this.head, tail = null;

		int carry = 0;

		while (node != null) {
			Integer product = node.data * x + carry;
			LLNode<Integer> newNode = new LLNode<Integer>((product) % 10, null);
			carry = (product) / 10;
			if (tail == null)
				newInt.head = newNode;
			else
				tail.link = newNode;
			tail = newNode;

			newInt.size++;

			node = node.link;
		}

		while (carry != 0) {
			LLNode<Integer> n = new LLNode<Integer>(carry % 10, null);
			tail.link = n;
			tail = n;
			carry /= 10;
			newInt.size++;
		}

		return newInt;
	}

	/**
	 * Recursive method that converts the list referenced by curr_node back to a
	 * string representing the integer. Think about what's the base case and what it
	 * should return. Then think about what it should return in non-base case. Hint:
	 * refer to the 'printing a list backwards' example we covered in lectures.
	 */
	private String toString(LLNode<Integer> curr_node) {
		if (curr_node != null) {
			toString(curr_node.link);
			num += curr_node.data;
		}
		return num;
	}

	/**
	 * Convert this list back to a string representing the large integer. This is a
	 * public method that jump-starts the call to the recursive method above.
	 */
	public String toString() {
		num = "";
		return toString(head);
	}

	// Recursive method to compute factorial
	public static LargeInteger factorial(int n) {
		if (n == 0)
			return new LargeInteger("1");
		return factorial(n - 1).multiply(n);
	}

	// Recursive method to compute power
	public static LargeInteger pow(int x, int y) {
		if (y == 0)
			return new LargeInteger("1");
		return pow(x, y - 1).multiply(x);

	}
}
