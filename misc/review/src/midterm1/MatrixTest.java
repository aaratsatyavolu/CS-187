package midterm1;

import org.junit.Test;
import java.util.Arrays;

public class MatrixTest {
	@Test
	public void testMatrix() {
		Matrix m = new Matrix(3, 3);
		for (int i = 0; i < m.rows; i++) {
			for (int j = 0; j < m.columns; j++) {
				m.matrix[i][j] = (int)(Math.random() * 10);
			}
		}
		System.out.println(Arrays.deepToString(m.matrix));
		m.transpose();
		System.out.println(Arrays.deepToString(m.matrix));
	}
}
