package midterm1;

public class PinapplePen {
	public static void applepen(int x, int y) {
		if (x == 0 || y == 0)
			System.out.print("Pen");
		else {
			applepen(x, y - 1);
			if ((x - y) % 2 == 1)
				System.out.print("Apple");
			else
				System.out.print("Pineapple");
			applepen(x - 1, y);
		}
	}
	
	public static void main(String[] args) {
		applepen(3,1);
	}
}
