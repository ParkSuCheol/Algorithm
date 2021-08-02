package greedy;

import java.util.Scanner;

public class Solution_BJ_N°úM2 {
	static int N, M;
	static int[] selected;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M + 1];
		sb = new StringBuilder();
		dfs(1);
		System.out.println(sb);
	}

	private static void dfs(int k) {
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int cand = selected[k - 1] + 1; cand <= N; cand++) {
				selected[k] = cand;
				dfs(k + 1);
			}
		}
	}
}
