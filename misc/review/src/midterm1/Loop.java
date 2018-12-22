package midterm1;

public class Loop {
	public static boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int i;
		for (i = 2; i < 10; i++) {
			if (isPrime(i))
				continue;
			System.out.println(i);
		}
		System.out.println("i=" + i);
	}

}
