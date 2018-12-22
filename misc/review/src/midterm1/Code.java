package midterm1;

public class Code {
	public static void foo(int i) throws Exception {
		System.out.print("a");
		if (i < 0)
			throw new Exception("b");
		System.out.print("c");
	}

	public static void main(String[] args) {
		try {
			System.out.print("d");
			foo(-1);
			System.out.print("e");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		System.out.print("f");
	}

}
