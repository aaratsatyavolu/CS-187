package midterm1;

public class Recursion {
	public static void dot(int n) {
		if (n > 0) {
			System.out.print(n);
			dot(n - 1);
		}
	}

	public static void foo(int n) {
		if (n > 0) {
			foo(n - 1);
			System.out.print(n);
		}
	}

	public static void bar(int n) {
		if (n > 0) {
			bar(n - 1);
			System.out.print(n);
			bar(n - 1);
		}
	}

	public static boolean isEven(int val) {
		if (val == 0)
			return true;
		if (val == 1)
			return false;
		if (val > 0)
			return isEven(val - 2);
		return isEven(val + 2);
	}

	public static int sumN(int n) {
		if (n == 0)
			return 0;
		if (n > 0)
			return n + sumN(n - 1);
		return n + sumN(n + 1);
	}

	public static int biPower(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return 2 * biPower(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(biPower(32));
	}

}
