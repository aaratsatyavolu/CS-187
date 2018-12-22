package midterm2;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPlayGround {
	public static void main(String[] args) {
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1));
		e.add(new Integer(7));
		for (Integer i : e)
			System.out.println(i);
	}

}
