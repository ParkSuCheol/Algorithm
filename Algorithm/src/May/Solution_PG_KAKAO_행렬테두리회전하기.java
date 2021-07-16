package May;

import java.util.*;

public class Solution_PG_KAKAO_행렬테두리회전하기 {
	public static void main(String[] args) {
		int[][] arr = { { 2, 2, 5, 4 }};
		System.out.println(Arrays.toString(solution(6, 6, arr)));
	}

	static int[][] matrix;

	public static int[] solution(int rows, int columns, int[][] queries) {
		matrix = new int[rows][columns];
		int[] answer = new int[queries.length];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = i * columns + j + 1;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotate(queries[i]);
		}

		return answer;
	}

	private static int rotate(int[] query) {
		int r1 = query[0] - 1;
		int c1 = query[1] - 1;
		int r2 = query[2] - 1;
		int c2 = query[3] - 1;

		int temp = matrix[r1][c1];
		int min = temp;

		for (int i = r1; i < r2; i++) {
			print();
			matrix[i][c1] = matrix[i + 1][c1];
			if (min > matrix[i][c1])
				min = matrix[i][c1];
		}
		
		System.out.println();

		for (int i = c1; i < c2; i++) {
			print();
			matrix[r2][i] = matrix[r2][i + 1];
			if (min > matrix[r2][i])
				min = matrix[r2][i];
		}

		System.out.println();

		for (int i = r2; i > r1; i--) {
			print();
			matrix[i][c2] = matrix[i - 1][c2];
			if (min > matrix[i][c2])
				min = matrix[i][c2];
		}

		System.out.println();

		for (int i = c2; i > c1; i--) {
			print();
			matrix[r1][i] = matrix[r1][i - 1];
			if (min > matrix[r1][i])
				min = matrix[r1][i];
		}

		System.out.println();
		
		matrix[r1][c1 + 1] = temp;

		print();
		
		return min;
	}

	public static void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();
		}
		System.out.println();
	}
}
