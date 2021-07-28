package greedy;

import java.util.Scanner;

public class Solution_BJ_N°úM4 {
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
			}sb.append("\n");
		}else {
			int start = selected[k-1];
			if(start == 0)
				start = 1;
			for(int cand = start; cand <= N; cand++) {
				selected[k] = cand;
				dfs(k+1);
			}
		}
	}
}
