
package guessme;

/**
 * An Array-based implementation of the Guess-A-Number game
 */
public class ArrayGame {

	// stores the next number to guess
	private int guess;
	private int[] allGuesses;
	private boolean[] eliminatedGuesses;
	private int numGuesses;
	private boolean gameOver;

	// TODO: declare additional data members, such as arrays that store
	// prior guesses, eliminated candidates etc.

	// NOTE: only primitive type arrays are allowed, such as int[], boolean[] etc.
	// You MAY NOT use any Collection type (such as ArrayList) provided by Java.

	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
	 * provided method, otherwise your code will fail the JUnit tests! Also DO NOT
	 * create any new Java files, as they will be ignored by the autograder!
	 *******************************************************/

	// ArrayGame constructor method
	public ArrayGame() {
		this.guess = 1000;
		this.allGuesses = new int[18];
		this.eliminatedGuesses = new boolean[9000];
		this.numGuesses = 0;
		this.gameOver = false;
	}

	// public int GuessGetter() {
	// return this.guess;
	// }
	//
	public int[] getAllGuesses() {
		return this.allGuesses;
	}

	public int getLastGuess() {
		return this.allGuesses[numGuesses - 1];
	}

	//
	// public boolean[] getEliminatedGuesses() {
	// return this.eliminatedGuesses;
	// }
	//
	public int getNumGuess() {
		return this.numGuesses;
	}
	//
	// public boolean getGameOver() {
	// return gameOver;
	// }

	// Resets data members and game state so we can play again
	public void reset() {
		this.guess = 1000;
		this.allGuesses = new int[18];
		this.eliminatedGuesses = new boolean[9000];
		this.numGuesses = 0;
		this.gameOver = false;
	}

	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		if (allGuesses[numGuesses - 1] == n) {
			return true;
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

	public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
		// turn integers a and b into arrays and compare at same time

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
	 * number has been correctly guessed or if all candidates have been eliminated.
	 */
	public boolean isOver() {
		return gameOver;
	}

	// Returns the guess number and adds it to the list of prior guesses.
	public int getGuess() {

		allGuesses[numGuesses] = guess;

		numGuesses++;

		return guess;
	}

	/**
	 * Updates guess based on the number of matches of the previous guess. If
	 * nmatches is 4, the previous guess is correct and the game is over. Check
	 * project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if all candidates have been
	 * eliminated (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {

		boolean notErroneous = true;

		if (nmatches == 4) {
			gameOver = true;
			isOver();
		}

		for (int i = 0; i < 9000; i++) {
			if (eliminatedGuesses[i]) {
			} else {
				if (numMatches(guess, i + 1000) != nmatches) {
					eliminatedGuesses[i] = true;
				}
			}
		}

		for (int i = 0; i < 9000; i++) {
			if (!eliminatedGuesses[i]) {
				guess = i + 1000;
				notErroneous = true;
				isOver();
				break;
			}
			if (eliminatedGuesses[i]) {
				notErroneous = false;
			}
		}

		return notErroneous;

	}

	// Returns the list of guesses so far as an integer array.
	// The size of the array must be the number of prior guesses.
	// Returns null if there has been no prior guess

	public int[] priorGuesses() {

		int[] priorGuesses = new int[numGuesses];
		if (numGuesses == 0) {
			return null;
		}

		else {
			for (int i = 0; i < numGuesses; i++) {
				priorGuesses[i] = allGuesses[i];
			}
		}
		return priorGuesses;

	}
}
