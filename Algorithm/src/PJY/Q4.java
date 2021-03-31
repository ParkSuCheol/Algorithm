package PJY;

public class Q4 {
	public static void main(String[] args) {
		System.out.println(solution(6, 4, 5, 6, new int[][] { { 2, 6, 6 }, { 6, 3, 7 }, { 4, 6, 7 }, { 6, 5, 11 },
				{ 2, 5, 12 }, { 5, 3, 20 }, { 2, 4, 8 }, { 4, 3, 9 } }));
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int INF = Integer.MAX_VALUE / 4, answer = INF;

		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (i != j)
					arr[i][j] = INF;
			}
		}

		for (int i = 0; i < fares.length; i++) {
			arr[fares[i][0]][fares[i][1]] = fares[i][2];
			arr[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int sum = arr[s][i] + arr[i][a] + arr[i][b];
			answer = Math.min(answer, sum);
		}

		return answer;
	}
}