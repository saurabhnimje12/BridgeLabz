package BridgeLabz_Array_Programs;

public class Matrix_Addition {
	public static int[][] addition() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = { { 7, 8, 9 }, { 2, 5, 8 }, { 3, 6, 9 } };
		int[][] matrix3 = new int[matrix1.length][matrix1[0].length];
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return matrix3;
	}

	public static void main(String[] args) {
		int[][] addition = addition();
		for (int i = 0; i < addition.length; i++) {
			for (int j = 0; j < addition[i].length; j++) {
				System.out.print(addition[i][j] + " ");
			}
		}
	}
}
