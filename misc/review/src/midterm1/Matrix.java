package midterm1;

public class Matrix {
	public int[][] matrix;
	public int rows, columns;

	public Matrix(int rows, int columns) {
		matrix = new int[rows][columns];
		this.rows = rows;
		this.columns = columns;
	}

	public void transpose() {
		int[][] newMatrix = new int[columns][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				newMatrix[j][i] = matrix[i][j];
			}
		}
		int temp = columns;
		columns = rows;
		rows = temp;
		matrix = newMatrix;
		return;
	}

	public boolean isToeplitz() {
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < columns - 1; j++) {
				if (matrix[i][j] != (matrix[i + 1][j + 1]))
					return false;
			}
		}
		return true;
	}
}
