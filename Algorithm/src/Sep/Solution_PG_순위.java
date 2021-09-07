package Sep;

public class Solution_PG_¼øÀ§ {
	public static void main(String[] args) {
		int[][] s = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(solution(5, s));
	}

	public static int solution(int n, int[][] results) {
		boolean[][] game = new boolean[n][n];
		int answer = 0;
		for (int i = 0; i < results.length; i++) {
			game[results[i][0] - 1][results[i][1] - 1] = true;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (game[i][k] && game[k][j]) {
						game[i][j] = true;
						System.out.println("i : "  + i + " j : "+ j);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			int result = 0;
			for (int j = 0; j < n; j++) {
				if (game[i][j] || game[j][i]) {
					result++;
				}
			}
			if (result == n - 1) {
				answer++;
			}
		}
		return answer;
	}
}
