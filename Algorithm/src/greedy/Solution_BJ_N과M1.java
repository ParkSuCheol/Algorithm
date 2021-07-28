package greedy;

import java.util.Scanner;

public class Solution_BJ_N°úM1 {
	static int N = 0, M = 0;
	static int[] selected, used;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[M + 1];
		used = new int[N + 1];
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
			for (int cand = 1; cand <= N; cand++) {
				if (used[cand] == 1)
					continue;
				selected[k] = cand;
				used[cand] = 1;
				dfs(k+1);
				used[cand] = 0;
			}
		}
	}

}
