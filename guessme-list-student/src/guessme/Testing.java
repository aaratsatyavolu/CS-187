package guessme;

public class Testing {
	
	public static LLIntegerNode candHead, candTail;
	

	public static LLIntegerNode tempHead;

	public static LLIntegerNode tempTail;

	public static void main(String[] args) {

		// int groundTruth = 4321;
		int guess1 = 2111;

		LinkedListGame game1 = new LinkedListGame();

		LLIntegerNode node = game1.getCandHead();

		// nmatches == 0

		while (node != null) {

			if (LinkedListGame.numMatches(guess1, node.getInfo()) == 1) {
				LLIntegerNode newNode = new LLIntegerNode(node.getInfo());
				if (tempTail == null) // if list is empty
					tempHead = newNode;
				else
					tempTail.setLink(newNode);
				tempTail = newNode;
			}

			node = node.getLink();
		}
		
		LLIntegerNode node2 = tempHead;
		while (node2 != null) {
			System.out.println(node2.getInfo());
			node2 = node2.getLink();
		}

	}

}
