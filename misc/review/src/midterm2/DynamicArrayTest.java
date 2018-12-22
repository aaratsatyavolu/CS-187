package midterm2;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class DynamicArrayTest {
	@Test
	public void testDynamicArray() {
		DynamicArray<Integer> a = new DynamicArray<Integer>(5);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		System.out.println(Arrays.toString(a.array));
		a.add(6);
		System.out.println(Arrays.toString(a.array));
		System.out.println(a.getLength());
	}
}
