package BridgeLabz_Array_Programs;

public class Matrix_Multiplication {
	public static int[][] multiply() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] matrix2 = { { 7, 8, 9 }, { 2, 5, 8 }, { 3, 6, 9 } };
		int[][] matrix3 = new int[matrix1.length][matrix1[0].length];
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				matrix3[i][j] = matrix1[i][j] * matrix2[i][j];
			}
		}
		return matrix3;
	}

	public static void main(String[] args) {
		int[][] multi = multiply();
		for (int i = 0; i < multi.length; i++) {
			for (int j = 0; j < multi[i].length; j++) {
				System.out.print(multi[i][j] + " ");
			}
		}
	}
}
