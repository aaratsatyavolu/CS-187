package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game
 */
public class LinkedListGame {

	private LLIntegerNode candHead, candTail; // work
	private LLIntegerNode tempHead, tempTail; // work
	private LLIntegerNode priorHead, priorTail; // work
	private boolean isOver;
	private int guess, numGuesses;

	// TODO: declare data members as necessary

	/********************************************************
	 * NOTE: for this project you must use linked lists implemented by yourself. You
	 * are NOT ALLOWED to use Java arrays of any type, or any class in the java.util
	 * package (such as ArrayList).
	 *******************************************************/

	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
	 * provided method, and do NOT add new files (as they will be ignored by the
	 * autograder).
	 *******************************************************/

	// LinkedListGame constructor method
	public LinkedListGame() {

		this.guess = 1000;
		this.numGuesses = 0;

		for (int i = 1000; i < 10000; i++) {
			endInsert(candHead, candTail, i);
		}

	}

	public LLIntegerNode getCandHead() {
		return this.candHead;
	}

	public LLIntegerNode getCandTail() {
		return this.candTail;
	}

	public LLIntegerNode getTempHead() {
		return this.tempHead;
	}

	public LLIntegerNode getTempTail() {
		return this.tempTail;
	}

	public LLIntegerNode getPriorHead() {
		return this.priorHead;
	}

	public LLIntegerNode getPriorTail() {
		return this.priorTail;
	}

	// Resets data members and game state so we can play again
	public void reset() {
		this.guess = 1000;
		this.candHead = null;
		this.candTail = null;

		for (int i = 1000; i < 10000; i++) {
			LLIntegerNode newNode = new LLIntegerNode(i);
			if (candTail == null) // if list is empty
				candHead = newNode;
			else
				candTail.setLink(newNode);
			candTail = newNode;
		}

		this.priorHead = null;
		this.priorTail = null;
		this.tempHead = null;
		this.tempTail = null;
		this.isOver = false;
		this.numGuesses = 0;

	}

	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		LLIntegerNode node = priorHead;

		while (node != null) {
			if (node.getInfo() == n) {
				return true;
			}
			node = node.getLink();
		}
		return false;
	}

	// Returns the number of guesses so far.
	public int numGuesses() {
		return numGuesses;
	}

	/**
	 * Returns the number of matches between integers a and b. You can assume that
	 * both are 4-digits long (i.e. between 1000 and 9999). The return value must be
	 * between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example: 1234 and 4321
	 * have 0 match; 1234 and 1114 have 2 matches (1 and 4); 1000 and 9000 have 3
	 * matches (three 0's).
	 */
	public static int numMatches(int a, int b) {
		int matchCounter = 0;

		for (int i = 0; i < 4; i++) {
			if (a % 10 == b % 10) {
				matchCounter++;
			}
			a /= 10;
			b /= 10;
		}

		return matchCounter;
	}

	/**
	 * Returns true if the game is over; false otherwise. The game is over if the
	 * number has been correctly guessed or if no candidate is left.
	 */
	public boolean isOver() {
		return isOver;
	}

	/**
	 * Returns the guess number and adds it to the list of prior guesses. The
	 * insertion should occur at the end of the prior guesses list, so that the
	 * order of the nodes follow the order of prior guesses.
	 */
	public int getGuess() {

		LLIntegerNode newNode = new LLIntegerNode(guess);

		if (priorTail == null) // if list is empty
			priorHead = newNode;
		else
			priorTail.setLink(newNode);

		priorTail = newNode;

		numGuesses++;

		return guess;
	}

	/**
	 * Updates guess based on the number of matches of the previous guess. If
	 * nmatches is 4, the previous guess is correct and the game is over. Check
	 * project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if no candidate is left
	 * (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {

		if (nmatches == 4) {
			isOver = true;
			isOver();
		}

		LLIntegerNode node = candHead;

		while (node != null) {
			if (numMatches(guess, node.getInfo()) == nmatches) {
				LLIntegerNode newNode = new LLIntegerNode(node.getInfo());
				if (tempTail == null) // if list is empty
					tempHead = newNode;
				else
					tempTail.setLink(newNode);
				tempTail = newNode;
			}
			node = node.getLink();
		}

		if (tempHead == null && tempTail == null) {
			return false;
		}

		candHead.setInfo(tempHead.getInfo());
		candHead.setLink(tempHead.getLink());

		guess = candHead.getInfo();
		tempHead = null;
		tempTail = null;

		return true;
	}

	// Returns the head of the prior guesses list.
	// Returns null if there hasn't been any prior guess
	public LLIntegerNode priorGuesses() {
		if (numGuesses != 0) {
			return priorHead;
		}
		return null;
	}

	public void endInsert(LLIntegerNode head, LLIntegerNode tail, int info) {
		LLIntegerNode newNode = new LLIntegerNode(info);
		if (tail == null) // if list is empty
			head = newNode;
		else
			tail.setLink(newNode);
		tail = newNode;
	}

	/**
	 * Returns the list of prior guesses as a String. For example, if the prior
	 * guesses are 1000, 2111, 3222, in that order, the returned string should be
	 * "1000, 2111, 3222", in the same order, with every two numbers separated by a
	 * comma and space, except the last number (which should not be followed by
	 * either comma or space).
	 *
	 * Returns an empty string if here hasn't been any prior guess
	 */
	public String priorGuessesString() {

		String priorString = new String();

		LLIntegerNode node = priorHead;

		if (node == null) {
			return "";
		}

		else {

			while (node != null) {
				if (node.getInfo() == 1000) {
					priorString += node.getInfo();
				} else {
					priorString += ", " + node.getInfo();
				}
				node = node.getLink();
			}
		}

		return priorString;
	}
}
